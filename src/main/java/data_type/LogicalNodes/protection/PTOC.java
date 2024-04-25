package data_type.LogicalNodes.protection;

import data_type.LogicalNodes.LN;
import data_type.measurements.WYE;
import data_type.protection.ACD;
import data_type.protection.ACT;
import data_type.setting.ASG;
import data_type.setting.ING;

public class PTOC extends LN {

    public static double dt = 1; // мили сек

    /* Входы  */

    public WYE A = new WYE();

    /* Выходы  */

    public ACD str = new ACD(); // выходной сигнал о срабатывании защиты
    public ACT Op = new ACT();  // выходной сигнал на отключение выключателя

    /* Уставки  */

    public ASG StrVal = new ASG(); // уставка по току

    public ING OpDITmms = new ING(); // выдержка времени


    /* Переменные  */
    //сколько итераций ток превышает уставку
    private int cntTimeA = 0;
    private int cntTimeB = 0;
    private int cntTimeC = 0;


    @Override
    public void process() {
        boolean strA = A.getPhsA().getCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();
        boolean strB = A.getPhsB().getCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();
        boolean strC = A.getPhsC().getCVal().getMag().getF().getValue() > StrVal.getSetMag().getF().getValue();


        str.getGeneral().setValue(strA || strB || strC);


        str.getPhsA().setValue(strA);
        str.getPhsB().setValue(strB);
        str.getPhsC().setValue(strC);

        cntTimeA = strA ? cntTimeA + 1 : 0;
        cntTimeB = strB ? cntTimeB + 1 : 0;
        cntTimeC = strC ? cntTimeC + 1 : 0;

        Op.getPhsA().setValue(cntTimeA * dt > OpDITmms.getSetVal().getValue());
        Op.getPhsB().setValue(cntTimeB * dt > OpDITmms.getSetVal().getValue());
        Op.getPhsB().setValue(cntTimeC * dt > OpDITmms.getSetVal().getValue());
        Op.getGeneral().setValue(
                cntTimeA * dt > OpDITmms.getSetVal().getValue() ||
                        cntTimeB * dt > OpDITmms.getSetVal().getValue() ||
                        cntTimeC * dt > OpDITmms.getSetVal().getValue());

    }
}
