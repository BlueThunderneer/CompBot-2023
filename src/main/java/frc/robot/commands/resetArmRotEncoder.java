package frc.robot.commands;
import frc.robot.subsystems.ArmSS;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class resetArmRotEncoder extends CommandBase {
    private final ArmSS m_armss; 

    public resetArmRotEncoder(ArmSS subsystem){
        m_armss = subsystem;
        addRequirements(m_armss);
    }

    @Override
    public void initialize(){
        m_armss.resetArmRotEncoder();
    }
    
    @Override 
    public void end(boolean interupted){
    }
}
