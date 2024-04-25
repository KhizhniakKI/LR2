package data_type.LogicalNodes.breakers;

import data_type.LogicalNodes.LN;
import data_type.controls.DPC;
import data_type.controls.INC;
import data_type.controls.SPC;
import data_type.protection.ACT;
import data_type.protection.SPS;

import java.util.ArrayList;
import java.util.List;

// Узел управления выключателем
public class CSWI extends LN {
    private SPS LocKey = new SPS();
    private SPS Loc = new SPS();
    //Сигнал на отключение от защиты
    public ACT OpOpn = new ACT();
    private SPS SelOpn = new SPS();
    public ACT OpCls =  new ACT();
    private SPS SelCls = new SPS();
    private INC OpCntRs = new INC();
    private SPC LocSta = new SPC();

    // Поля хранящие выходные значения сигнала на отключения фаз выключателя
    public DPC Pos = new DPC();
    public DPC PosA= new DPC();
    public DPC PosB= new DPC();
    public DPC PosC= new DPC();


    public List<ACT> SignalsList = new ArrayList();

    @Override
    public void process() {
        //Проверка наличия сигнала на отключение выключателя от защиты
        SelOpn.getStVal().setValue(false);
        for (ACT act : SignalsList) {
            if (act.getGeneral().getValue()) {
                SelOpn.getStVal().setValue(true);
                break;
            }
        }
        SelCls.getStVal().setValue(!SelOpn.getStVal().getValue());

        if (SelOpn.getStVal().getValue()) {
            Pos.getStVal().setValue(DPC.Values.OFF);
            PosA.getStVal().setValue(DPC.Values.OFF);
            PosB.getStVal().setValue(DPC.Values.OFF);
            PosC.getStVal().setValue(DPC.Values.OFF);
        } else {
            Pos.getStVal().setValue(DPC.Values.ON);
            PosA.getStVal().setValue(DPC.Values.ON);
            PosB.getStVal().setValue(DPC.Values.ON);
            PosC.getStVal().setValue(DPC.Values.ON);
        }
    }
}
