package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonTime2 extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on time. This will drive out for a period of time, turn
   * around for time (equivalent to time to turn around) and drive forward again. This should mimic
   * driving out, turning around and driving back.
   *
   * 
   */
  public AutonTime2(ClawSS m_ClawSS, DriveSubsystem m_drivetrain, ArmSS m_armss) {
       addCommands(
        new armdownTime(0.5, m_armss), // Lowers arm because yes
        //new armupTime(3.0, m_armss), //Raise the Cargo arm to shoot need to add this subsystem to the contstructor)
        new extendTime(0.5, m_armss),
        new ItsClawinTime(1.0, m_ClawSS), // Not a Morbius reference (Opens le claw)
        new retractTime(0.5, m_armss),
        //new Time(1),     //One Second Delay
        //new ArmdownTime(1.0, m_ArmSS),
        new armupTime(3.0, m_armss), //Raise the Cargo arm to shoot need to add this subsystem to the contstructor)
        //new armdownTime(0.5, m_armss),
        //new DriveDistance( 0.75, 0, 216, m_drivetrain )
        new DriveTime( -0.55, 0.0, 5.0, m_drivetrain) // go forward for X seconds
        // Caffiene addiction lvl 100
        ); //end of addCommands
     
  }    
}
