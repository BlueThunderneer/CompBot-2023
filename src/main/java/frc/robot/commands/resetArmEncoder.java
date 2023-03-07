package frc.robot.commands;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class resetArmEncoder extends CommandBase {
    private final ArmSS m_armss; 

    public resetArmEncoder(ArmSS subsystem){
        m_armss = subsystem;
        addRequirements(m_armss);
    }

    @Override
    public void initialize(){
        m_armss.resetArmEncoder();
    }
    
    @Override 
    public void end(boolean interupted){
    }
}
