package data_type.LogicalNodes.protocol;

import data_type.LogicalNodes.LN;
import data_type.measurements.SAV;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LSVS extends LN {

//    путь к файлу и его имя
    @Setter @Getter
    private String path;
    @Setter @Getter
    private String fileName;

//    список записанных значений
    @Setter @Getter
    private final List<SAV> out = new ArrayList<>();

//    Листы для считывания файла конфигурации
    private List<String> cfgFileList = new ArrayList<>();
    private List<String> datFileList = new ArrayList<>();

//    листы для записи коэффициентов
    private List<Double> kAList = new ArrayList<>();
    private List<Double> kBList = new ArrayList<>();


//    Итератор

    private Iterator<String> datIterator;

    private int analogNumber = 0;
    private int discretNumber = 0;

    public LSVS(){
        for (int i = 0 ; i <80 ; i++) out.add(new SAV());
    }
    @Override
    public void process() {
        if (this.datIterator.hasNext()){
            String []  str = this.datIterator.next().split(",");

            for (int i = 2 , j = 0; i < this.analogNumber+2 ; i++, j++){
                double value = 1000 * (Double.parseDouble(str[i]) * this.kAList.get(j) + this.kBList.get(j));
                this.out.get(j).getInstMag().getF().setValue(value);
//                this.out.get(j).getInstMag().setF(value);
            }
        }
    }

    public boolean hasNextData(){
        return  this.datIterator.hasNext();
    }

    public void setFileName(String fileName) throws Exception {
        this.fileName = fileName;


        String cfgPath = path + fileName + ".cfg";
        String datPath = path + fileName + ".dat";

        File cfgFile = new File(cfgPath);
        File datFile = new File(datPath);

        if (!cfgFile.exists()) throw new Exception("Путь указан неверно");
        if (!datFile.exists()) throw new Exception("Путь указан неверно");

        this.cfgFileList = Files.readAllLines(cfgFile.toPath());
        this.datFileList = Files.readAllLines(datFile.toPath());
        datIterator = datFileList.listIterator();
        String strNumber = this.cfgFileList.get(1)
                .replace("A", "")
                .replace("D", "");

        this.analogNumber = Integer.parseInt(strNumber.split(",")[1]);
        this.discretNumber = Integer.parseInt(strNumber.split(",")[2]);

        for (int i = 2 ; i < this.analogNumber + 2 ; i++){
            double kA = Double.parseDouble(this.cfgFileList.get(i).split(",")[5]);
            double kB = Double.parseDouble(this.cfgFileList.get(i).split(",")[6]);
            kAList.add(kA);
            kBList.add(kB);
        }
    }
}
