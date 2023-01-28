package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Robot extends TimedRobot {

  //Timer
  private final Timer m_timer = new Timer();

  //Joystick
  private final Joystick m_driverController = new Joystick(0);

  //Joystick Buttons
  JoystickButton button7 = new JoystickButton(m_driverController, 7);
  JoystickButton button8 = new JoystickButton(m_driverController, 8);
  JoystickButton button9 = new JoystickButton(m_driverController, 9);
  JoystickButton button10 = new JoystickButton(m_driverController, 10);

  //Left Motors
  private static WPI_TalonSRX m_frontLeftMotor = new WPI_TalonSRX(1);
  private static WPI_VictorSPX m_rearLeftMotor = new WPI_VictorSPX(2);
  private static MotorControllerGroup m_left = new MotorControllerGroup(m_frontLeftMotor, m_rearLeftMotor);

  //Right Motors
  private static WPI_VictorSPX m_frontRightMotor = new WPI_VictorSPX(3);
  private static WPI_TalonSRX m_rearRightMotor = new WPI_TalonSRX(0);
  private static MotorControllerGroup m_right = new MotorControllerGroup(m_frontRightMotor, m_rearRightMotor);

  private static DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

  private Command m_autonomousCommand;

  @Override
  public void robotInit() {

    //Reverses right motors
    m_frontRightMotor.setInverted(true);
    m_rearRightMotor.setInverted(true);

  }

  public Timer getM_timer() {
    return m_timer;
  }


  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }


  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}


  @Override
  public void autonomousInit() {
  
  }

  @Override
  public void autonomousPeriodic() {
  
  }


  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {

    m_drive.arcadeDrive(-m_driverController.getY(), m_driverController.getX());

  }

}