package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class extendTime extends CommandBase{

    private final ArmSS m_armSS; 

    private final double m_duration;

    private long m_startTime;

    public extendTime(double time, ArmSS subsytem){
        m_armSS = subsytem;
        m_duration = time * 1000;
        addRequirements(m_armSS);
    }

    @Override
    public void initialize(){
        m_startTime = System.currentTimeMillis();
        m_armSS.ArmOut();
    }
    
    @Override
    public void end(boolean interrupted){
        m_armSS.stop();
    }
    @Override
    public boolean isFinished(){
        return(System.currentTimeMillis() - m_startTime) >= m_duration;
    }
}