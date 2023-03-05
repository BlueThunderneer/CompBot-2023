package frc.robot.commands;

import frc.robot.subsystems.ClawSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ItsClawinTime extends CommandBase{

    private final ClawSS m_ClawSS;

    private final double m_duration;

    private long m_startTime; 
    
    public ItsClawinTime(double time, ClawSS subsytem){
        m_ClawSS = subsytem;
        m_duration = time * 1000;
        addRequirements(m_ClawSS);
    }

    @Override
    public void initialize(){
        m_startTime = System.currentTimeMillis();
        m_ClawSS.OpenClaw();
    }
    @Override
    public void end(boolean interrupted){
        m_ClawSS.stop();
    }
    @Override
    public boolean isFinished(){
        return(System.currentTimeMillis()-m_startTime)>= m_duration;
    }


}
