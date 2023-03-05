package frc.robot.commands;

import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistance extends CommandBase {
    private final double m_xaxisSpeed;
    private final double m_zaxisRotate;
    private final double m_distance;
    private final DriveSubsystem m_drivetrain;
    private double d_encoder;

public DriveDistance(double xSpeed, double zRotate, double distance, DriveSubsystem drive) {
    m_xaxisSpeed = xSpeed;
    m_zaxisRotate = zRotate;
    m_drivetrain = drive;
    m_distance = distance;
    addRequirements(drive);
}


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetEncoders();
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
    d_encoder = m_drivetrain.getAverageEncoderDistance();
    return d_encoder >= m_distance;
  }   
}
