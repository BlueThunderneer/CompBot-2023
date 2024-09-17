// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import frc.robot.subsystems.ColorSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
<<<<<<< Updated upstream
  public final ArmSS m_armss = new ArmSS();
  public final ClawSS m_clawss = new ClawSS();
=======


  public final CannonSS m_cannonss = new CannonSS();
  //public final CandySS m_candyss = new CandySS();
>>>>>>> Stashed changes
  public final ColorSubsystem m_colorss = new ColorSubsystem();
  // The driver's controller
  private final Joystick m_driverController = new Joystick(0);
  private final Joystick m_driverController2 = new Joystick(1);

  private final Joystick m_opJoy1 = new Joystick(2);

  // configure Auton commands here.
<<<<<<< Updated upstream
  private final Command m_LandDAuto = new AutonTime2(m_clawss, m_robotDrive, m_armss);
  private final Command m_LandDAuto2 = new AutonTime3(m_clawss, m_robotDrive, m_armss);
=======
>>>>>>> Stashed changes
  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Configure default commands

    //Auton Options
<<<<<<< Updated upstream
    m_chooser.setDefaultOption("Launch n Drive", m_LandDAuto);
    m_chooser.addOption("Launch n Drive", m_LandDAuto);
    m_chooser.addOption("Launch n Drive n Pickup", m_LandDAuto2);
=======
>>>>>>> Stashed changes
    // Configure autonomous sendable chooser
    SmartDashboard.putData("Auto Mode", m_chooser);

    // Set the default drive command to split-stick arcade drive
    m_robotDrive.setDefaultCommand(
        // A split-stick arcade command, with forward/backward controlled by the left
        // hand, and turning controlled by the right.
        new RunCommand(
            () ->
                m_robotDrive.arcadeDrive(
                    -m_driverController.getRawAxis(1), -m_driverController.getRawAxis(2)),m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link PS4Controller}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.
    new JoystickButton(m_opJoy1, 2).whenHeld(new Fill(m_cannonss));
    new JoystickButton(m_opJoy1, 1).whenHeld(new Launch(m_cannonss));
    new JoystickButton(m_driverController2, 6).whenHeld(new Fill(m_cannonss));
    // new JoystickButton(m_driverController2, 8).whenHeld();

    //Moved this to Joystick Axis
    //new JoystickButton(m_opJoy1, 5).whenHeld(new ArmUp(m_armss));
    // JoystickButton(m_opJoy1, 3).whenHeld(new ArmDown(m_armss));
<<<<<<< Updated upstream
    new JoystickButton(m_opJoy1, 7).whenPressed(new resetArmEncoder(m_armss));
    new JoystickButton(m_opJoy1, 8).whenPressed(new resetArmRotEncoder(m_armss));
    new JoystickButton(m_opJoy1, 4).whenHeld(new ArmIn(m_armss));
    new JoystickButton(m_opJoy1, 6).whenHeld(new ArmOut(m_armss));
    new JoystickButton(m_driverController, 4).whenPressed(new airOFF(m_clawss));
    new JoystickButton(m_driverController, 3).whenPressed(new airON(m_clawss));
=======
    new JoystickButton(m_driverController, 4).whenPressed(new airOFF(m_cannonss));
    new JoystickButton(m_driverController, 3).whenPressed(new airON(m_cannonss));

>>>>>>> Stashed changes
    //new JoystickButton(m_opJoy1, 11).whenPressed(new addArmRotEncoder(m_armss)); THIS BREAKS STUFF!!!
   }

public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
 // public Command getAutonomousCommand() {
    //return new AutonTime2(m_clawss, m_robotDrive, m_armss);
 // }

}
