package data_type.LogicalNodes.measurements;

import data_type.LogicalNodes.LN;
import data_type.measurements.DEL;
import data_type.measurements.MV;
import data_type.measurements.SAV;
import data_type.measurements.WYE;
import data_type.sequence.SEQ;
import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.*;

@Getter
@Setter
public class MSQI extends LN {

    private SEQ SeqA = new SEQ();
    private SEQ SeqV = new SEQ();
    private SEQ DQ0Seq = new SEQ();

    private WYE ImbA = new WYE();

    private MV ImbNgA = new MV();
    private MV ImbNgV = new MV();

    private DEL ImbPPV = new DEL();

    private WYE ImbV = new WYE();

    private MV ImbZroA = new MV();
    private MV ImbZroV = new MV();
    private MV MaxImbA = new MV();
    private MV MaxImbPPV = new MV();
    private MV MaxImbV = new MV();


//    Входные данные: мгновенные значения токов и напряжений

    public WYE A = new WYE();
    public WYE PNV = new WYE();


    @Override
    public void process() {
        double MagA = A.getPhsA().getCVal().getMag().getF().getValue();
        double MagB = A.getPhsB().getCVal().getMag().getF().getValue();
        double MagC = A.getPhsC().getCVal().getMag().getF().getValue();

        double AngA = toRadians(A.getPhsA().getCVal().getAng().getF().getValue());
        double AngB = toRadians(A.getPhsB().getCVal().getAng().getF().getValue());
        double AngC = toRadians(A.getPhsC().getCVal().getAng().getF().getValue());


//        double fgfg = pow(MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[0] +
//                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[0], 2);
//        double gjfghkfg = (1.0 / 3.0 * (sqrt((pow(MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[0] +
//                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[0], 2)) +
//                pow(MagA * sin(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[1] +
//                        rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[1], 2))));



        SeqA.getC3().getCVal().getMag().getF().setValue(1.0 / 3.0 * (sqrt((pow(MagA * cos(AngA) + MagB * cos(AngB) + MagC * cos(AngC), 2)) + pow(MagA * sin(AngA) + MagB * sin(AngB) + MagC * sin(AngC), 2))));
        SeqA.getC3().getCVal().getAng().getF().setValue(atan(toRadians(MagA * sin(AngA) + MagB * sin(AngB) + MagC * sin(AngC) / (MagA * cos(AngA) + MagB * cos(AngB) + MagC * cos(AngC)))));

        SeqA.getC1().getCVal().getMag().getF().setValue(1.0 / 3.0 * (sqrt((pow(MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[0] +
                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[0], 2)) +
                pow(MagA * sin(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[1] +
                        rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[1], 2))));

        SeqA.getC1().getCVal().getAng().getF().setValue(atan(toRadians(
                (MagA * sin(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[1] +
                        rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[1]) /
                        (MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 120)[0] +
                                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 240)[0])
        )));

        SeqA.getC2().getCVal().getMag().getF().setValue(1.0 / 3.0 * (sqrt((pow(MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 240)[0] +
                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 120)[0], 2)) +
                pow(MagA * sin(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 240)[1] +
                        rotateVector(MagC * cos(AngC), MagC * sin(AngC), 120)[1], 2))));

        SeqA.getC2().getCVal().getAng().getF().setValue(atan(toRadians(
                (MagA * sin(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 240)[1] +
                        rotateVector(MagC * cos(AngC), MagC * sin(AngC), 120)[1]) /
                        (MagA * cos(AngA) + rotateVector(MagB * cos(AngB), MagB * sin(AngB), 240)[0] +
                                rotateVector(MagC * cos(AngC), MagC * sin(AngC), 120)[0])
        )));
    }


    public static double[] rotateVector(double x, double y, double angle) {
        double[] rotatedVector = new double[3];

        double sin = Math.sin(Math.toRadians(angle));
        double cos = Math.cos(Math.toRadians(angle));

        double oldx = x;
        double oldy = y;

        x = oldx * cos - oldy * sin;
        y = oldx * sin + oldy * cos;

        double magnitude = Math.sqrt(x * x + y * y);
        double angleAfterRotation = Math.atan2(y, x) * 180 / Math.PI;

        rotatedVector[0] = x;
        rotatedVector[1] = y;
        rotatedVector[2] = angleAfterRotation;

        return rotatedVector;
    }
}
