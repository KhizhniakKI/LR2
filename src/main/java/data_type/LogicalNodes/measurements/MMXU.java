package data_type.LogicalNodes.measurements;

import data_type.LogicalNodes.LN;
import data_type.measurements.DEL;
import data_type.measurements.SAV;
import data_type.measurements.WYE;
import utils.Filter;
import utils.Fourier;

public class MMXU extends LN {

    public static int busSize = 80;


    private SAV TotW = new SAV();
    private SAV TotVAr = new SAV();
    private SAV TotVA = new SAV();
    private SAV TotPF = new SAV();
    private SAV Hz = new SAV();
    private DEL PPV = new DEL();

    private WYE PhV = new WYE();
    private WYE W = new WYE();
    private WYE VAr = new WYE();
    private WYE VA = new WYE();
    private WYE PF = new WYE();
    private WYE Z = new WYE();

    /* Входы */

    public SAV UaInst = new SAV();
    public SAV UbInst = new SAV();
    public SAV UcInst = new SAV();

    public SAV IaInst = new SAV();
    public SAV IbInst = new SAV();
    public SAV IcInst = new SAV();

    /* Выходы */

    public WYE A = new WYE();
    public WYE PNV = new WYE();


    /* Экземпляры класса фильрт  */

    private final Filter ia = new Fourier(busSize);
    private final Filter ib = new Fourier(busSize);
    private final Filter ic = new Fourier(busSize);

    private final Filter ua = new Fourier(busSize);
    private final Filter ub = new Fourier(busSize);
    private final Filter uc = new Fourier(busSize);


    @Override
    public void process() {
        // передача мгновенных значений и атрибута для записи результата
        this.ia.process(this.IaInst, A.getPhsA().getCVal());
        this.ib.process(this.IbInst, A.getPhsB().getCVal());
        this.ic.process(this.IcInst, A.getPhsC().getCVal());

//        this.ua.process(this.UaInst, PNV.getPhsA().getCVal());
//        this.ub.process(this.UbInst, PNV.getPhsB().getCVal());
//        this.uc.process(this.UcInst, PNV.getPhsC().getCVal());
    }
}
