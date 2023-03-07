package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveTime extends CommandBase {
    private final double m_xaxisSpeed;
    private final double m_zaxisRotate;
    private final double m_duration;
    private final DriveSubsystem m_drivetrain;
    private long m_startTime;

public DriveTime(double xSpeed, double zRotate, double time, DriveSubsystem drive) {
    m_xaxisSpeed = xSpeed;
    m_zaxisRotate = zRotate;
    m_duration = time * 1000;
    m_drivetrain = drive;
    addRequirements(drive);
}


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(m_xaxisSpeed, m_zaxisRotate);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (System.currentTimeMillis() - m_startTime) >= m_duration;
  }   
}