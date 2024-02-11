// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.motorcontrol.PWMMotorController;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kSpeakerMid = "Speaker Middle";
  private static final String kRedLongAuto = "Red Long Speaker and Backup";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private TalonSRX leftFront; 
  private TalonSRX rightFront;
  private TalonSRX leftBack;
  private TalonSRX rightBack;


 
  

  private final Timer timer1 = new Timer();

  private final TalonSRX FeedWheel = new TalonSRX(5);
  private final TalonSRX LaunchWheel = new TalonSRX(6);

  private final XboxController driverController = new XboxController(0);
  private final XboxController operatorController = new XboxController(1);

  double driveLimit = 1;
  double launchPower = 0;
  double feedPower = 0; 


  /**
   * This function is run when the robot is first started up and should be used
   * for any
  private final MotorController leftMotors = new MotorControllerGroup(leftFront, leftBack);
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("Speaker middle", kSpeakerMid);
    m_chooser.addOption("Red Long Speaker and Backup", kRedLongAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    leftFront = new TalonSRX(1);
    rightFront = new TalonSRX(2);
    leftBack = new TalonSRX(3);
    rightBack = new TalonSRX(4);

    leftFront.setInverted(true);
    leftBack.setInverted(true);
    rightFront.setInverted(false);
    rightBack.setInverted(false);

    leftBack.follow(leftFront);
    rightBack.follow(rightFront);

    
    // DifferentialDrive drive = new DifferentialDrive(leftFront, rightFront);
    // drive.arcadeDrive(0.5, 0.5);
    
    FeedWheel.setInverted(true);
    LaunchWheel.setInverted(true);



    timer1.start();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items
   * like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {

    leftFront.set(TalonSRXControlMode.PercentOutput , driverController.getLeftY());
    rightFront.set(TalonSRXControlMode.PercentOutput, driverController.getRightY());

    FeedWheel.set(TalonSRXControlMode.PercentOutput, operatorController.getLeftY());
    LaunchWheel.set(TalonSRXControlMode.PercentOutput, operatorController.getRightY());
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different
   * autonomous modes using the dashboard. The sendable chooser code works with
   * the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the
   * chooser code and
   * uncomment the getString line to get the auto name from the text box below the
   * Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional comparisons to the
   * switch structure
   * below with additional strings. If using the SendableChooser make sure to add
   * them to the
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);

    timer1.reset();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    //  switch (m_autoSelected) {
    //    case kRedLongAuto:
    //      if(timer1.get()< 1)
    //      {
    //        LaunchWheel.set(1);
          
    //      }
    //      else if(timer1.get()< 3.0)
    //      {
    //        LaunchWheel.set(1);
    //        FeedWheel.set(0);
    //      }
    //      else if(timer1.get()<5.0){
    //        LaunchWheel.set(0);
    //       FeedWheel.set(0);
    //        myDrive.tankDrive(0, 0);
    //     }
    //      else{
    //        LaunchWheel.set(0);
    //        FeedWheel.set(0);
    //     }
    //     break;
    //   case kSpeakerMid: // start middle speaker lauch & back up
    //   case kDefaultAuto:
    //   break;
    //   default:
    //     if(timer1.get() < 5.0)
    //     {
    //       myDrive.tankDrive(.4, .4);
    //     }
    //     else
    //     {
    //       myDrive.tankDrive(0, 0);
    //     }
    //     break;
    // }
  }
  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
        //drive train
    //myDrive.tankDrive(-driverController.getLeftY(), -driverController.getRightY());
    // myDrive.arcadeDrive(-driverController.getLeftY()*driveLimit, -driverController.getRightX()*driveLimit);

    // if(driverController.getRightBumper()){
    //   driveLimit = 1;
    // } else if(driverController.getLeftBumper()){
    //   driveLimit = .5; 
    // }

    // //launcher
    //     if(operatorController.getLeftBumper()){
    //       launchPower = -1;
    //       feedPower = -.2;
    //     } else{
    //         if (operatorController.getAButton() == true) {
    //           timer1.reset();
    //         }
    //         if (timer1.get() < 1.0){  //spool launch wheel
    //            launchPower = 1;
    //            feedPower = 0;
    //         }
    //         else if (timer1.get() < 2.0){  //launch 
    //            launchPower = 1;
    //            feedPower = 1;
    //         }
    //         else if (timer1.get() < 3.0){  //launch 
    //            launchPower = 0;
    //            feedPower = 0;
    //         }
    //     }
        // LaunchWheel.set(launchPower);
        // FeedWheel.set(feedPower); 
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}

}