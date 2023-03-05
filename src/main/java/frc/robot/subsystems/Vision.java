package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Vision extends SubsystemBase {
    private NetworkTable m_llTable;
    private double tx, ty, ta;


    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        m_llTable = NetworkTableInstance.getDefault().getTable("limelight");
         tx = m_llTable.getEntry("tx").getDouble(4);
         ty = m_llTable.getEntry("ty").getDouble(4);
         ta = m_llTable.getEntry("ta").getDouble(4);
    
        SmartDashboard.putNumber("LimelightY", ty);
        SmartDashboard.putNumber("LimelightArea", ta);
        SmartDashboard.putNumber("LimelightX", tx);
    }
    public double getTX(){
        
        return tx;
    }
    public double getTA(){
        
        return ta;
    }
}
