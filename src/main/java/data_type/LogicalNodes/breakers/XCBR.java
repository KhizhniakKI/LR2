package data_type.LogicalNodes.breakers;

import data_type.LogicalNodes.LN;
import data_type.controls.DPC;
import data_type.controls.SPC;
import data_type.description.DPL;
import data_type.protection.BCR;
import data_type.protection.ENS;
import data_type.protection.INS;
import data_type.protection.SPS;
import data_type.setting.ING;

// Узел контроля состояния выключателя
public class XCBR extends LN {
    private DPL EEName = new DPL();
    private ENS EEHealth = new ENS();
    private SPS LocKey = new SPS();
    private SPS Loc = new SPS();
    private INS OpCnt = new INS();
    private ENS CBOpCap = new ENS();
    private ENS POWCap = new ENS();
    private INS MaxOpCap = new INS();
    private SPS Dsc = new SPS();
    private BCR SumSwARs = new BCR();
    private SPC LocSta = new SPC();
    // положение выключателя
    public DPC Pos = new DPC();
    public SPC BlkOpn = new SPC();
    public SPC BlkCls = new SPC();
    private SPC ChaMotEna = new SPC();
    private ING CBTmms = new ING();

    @Override
    public void process() {

    }
}

