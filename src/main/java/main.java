import data_type.LogicalNodes.LN;
import data_type.LogicalNodes.breakers.CSWI;
import data_type.LogicalNodes.breakers.XCBR;
import data_type.LogicalNodes.measurements.MMXU;
import data_type.LogicalNodes.measurements.MSQI;
import data_type.LogicalNodes.protection.PTOC;
import data_type.LogicalNodes.protocol.LSVS;
import hmi.NHMI;
import hmi.other.NHMISignal;

import java.util.ArrayList;
import java.util.List;

public class main {


    private static final List<LN> logicalNodes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        LSVS lsvs = new LSVS();
        lsvs.setPath("C:\\Users\\Khizh\\IdeaProjects\\Algoritmes\\LR1\\src\\main\\resources\\Начало линии\\");
        lsvs.setFileName("PhA80");
//        lsvs.setFileName("PhAB80");
//        lsvs.setPath("C:\\Users\\Khizh\\IdeaProjects\\Algoritmes\\LR1\\src\\main\\resources\\Конец линии\\");
//        lsvs.setFileName("PhABC80");
//        lsvs.setFileName("PhB80");

        logicalNodes.add(lsvs);


        MMXU mmxu = new MMXU();
        logicalNodes.add(mmxu);
        mmxu.IaInst = lsvs.getOut().get(0);
        mmxu.IbInst = lsvs.getOut().get(1);
        mmxu.IcInst = lsvs.getOut().get(2);

        MSQI msqi = new MSQI();
        ;
        logicalNodes.add(msqi);





        PTOC ptoc1 = new PTOC();
        logicalNodes.add(ptoc1);
        msqi.A = mmxu.A;
        ptoc1.A = mmxu.A;
        ptoc1.StrVal.getSetMag().getF().setValue(412.0);
        ptoc1.OpDITmms.getSetVal().setValue(200);


        PTOC ptoc2 = new PTOC();
        logicalNodes.add(ptoc2);
        ptoc2.A = mmxu.A;
        ptoc2.StrVal.getSetMag().getF().setValue(412.0);
        ptoc2.OpDITmms.getSetVal().setValue(800);


        PTOC ptoc3 = new PTOC();
        logicalNodes.add(ptoc3);
        ptoc3.A = mmxu.A;
        ptoc3.StrVal.getSetMag().getF().setValue(412.0);
        ptoc3.OpDITmms.getSetVal().setValue(1000);


        CSWI cswi = new CSWI();
        logicalNodes.add(cswi);
        cswi.SignalsList.add(ptoc1.Op);
        cswi.SignalsList.add(ptoc2.Op);
        cswi.SignalsList.add(ptoc3.Op);

        XCBR xcbr = new XCBR();
        logicalNodes.add(xcbr);
        xcbr.Pos = cswi.Pos;


        //прОвека ФИЛЬТАР СИММЕТРИЧНЫХ ПОСЛЕДОВАТЕЛЬНОСТЕЙ
        NHMI sequenceMag = new NHMI();
        logicalNodes.add(sequenceMag);

        sequenceMag.addSignals(
                new NHMISignal("C1Mag",  msqi.getSeqA().getC1().getCVal().getMag().getF()));
        sequenceMag.addSignals(
                new NHMISignal("C2Mag",  msqi.getSeqA().getC2().getCVal().getMag().getF()));
        sequenceMag.addSignals(
                new NHMISignal("C3Mag",  msqi.getSeqA().getC3().getCVal().getMag().getF()));

        NHMI sequenceAng = new NHMI();
        logicalNodes.add(sequenceAng);
        sequenceAng.addSignals(
                new NHMISignal("C1Ang",  msqi.getSeqA().getC1().getCVal().getAng().getF()));
        sequenceAng.addSignals(
                new NHMISignal("C2Ang",  msqi.getSeqA().getC2().getCVal().getAng().getF()));
        sequenceAng.addSignals(
                new NHMISignal("C3Ang",  msqi.getSeqA().getC3().getCVal().getAng().getF()));
        //

        NHMI nhmiCurrents = new NHMI();
        logicalNodes.add(nhmiCurrents);
        nhmiCurrents.addSignals(
                new NHMISignal("ia", lsvs.getOut().get(0).getInstMag().getF())
        );
        nhmiCurrents.addSignals(
                new NHMISignal("ib", lsvs.getOut().get(1).getInstMag().getF())
        );
        nhmiCurrents.addSignals(
                new NHMISignal("ic", lsvs.getOut().get(2).getInstMag().getF())
        );

        NHMI nhmiRmsAndStrVal = new NHMI();
        logicalNodes.add(nhmiRmsAndStrVal);

        nhmiRmsAndStrVal.addSignals(
                new NHMISignal("rmsA", mmxu.A.getPhsA().getCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );
        nhmiRmsAndStrVal.addSignals(
                new NHMISignal("rmsB", mmxu.A.getPhsB().getCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );
        nhmiRmsAndStrVal.addSignals(
                new NHMISignal("rmsC", mmxu.A.getPhsC().getCVal().getMag().getF()),
                new NHMISignal("StrValPtoc1", ptoc1.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc2", ptoc2.StrVal.getSetMag().getF()),
                new NHMISignal("StrValPtoc3", ptoc3.StrVal.getSetMag().getF())
        );
        NHMI nhmiDiscret = new NHMI();
        logicalNodes.add(nhmiDiscret);
        nhmiDiscret.addSignals(
                new NHMISignal("StrPtoc1", ptoc1.str.getGeneral())
        );
        nhmiDiscret.addSignals(
                new NHMISignal("OpPtoc1", ptoc1.Op.getGeneral())
        );
        nhmiDiscret.addSignals(
                new NHMISignal("StrPtoc2", ptoc2.str.getGeneral())
        );
        nhmiDiscret.addSignals(
                new NHMISignal("OpPtoc2", ptoc2.Op.getGeneral())
        );
        nhmiDiscret.addSignals(
                new NHMISignal("StrPtoc3", ptoc3.str.getGeneral())
        );
        nhmiDiscret.addSignals(
                new NHMISignal("OpPtoc3", ptoc3.Op.getGeneral())
        );



        while (lsvs.hasNextData()) {
            logicalNodes.forEach(LN::process);
        }
    }
}




