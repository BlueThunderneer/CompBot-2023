package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class BalanceLoop extends CommandBase {
    private AutoBalance m_autobalance;
    private final DriveSubsystem m_drivetrain;
    private final double m_duration;
    private long m_startTime;

    public BalanceLoop(double time, DriveSubsystem subsystem){
        m_drivetrain = subsystem;
        m_duration = time * 1000;
        addRequirements(m_drivetrain);
    }    

    @Override
    public void initialize(){
        m_startTime = System.currentTimeMillis();
    }
    @Override
    public void execute(){

        m_autobalance = new AutoBalance();
        double m_speed = m_autobalance.autoBalanceRoutine();
        m_drivetrain.arcadeDrive(m_speed, 0);    }

    @Override 
    public void end(boolean interupted){
    }
    @Override
    public boolean isFinished(){
        return(System.currentTimeMillis()-m_startTime)>= m_duration;
    }

}