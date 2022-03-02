# Rapid React

[![Open in Visual Studio Code](https://open.vscode.dev/badges/open-in-vscode.svg)](https://open.vscode.dev/frc3624/rapid-react) [![Website monip.org](https://img.shields.io/website-up-down-green-red/http/monip.org.svg)](http://www.team3624.org/)

**CURRENT PLAN FOR AUTONOMOUS**

Going to utilize sequential and parallel command groups alongside PathWeaver. The shooting/intake routines will be conglomerated into a Sequential Command Group. They will have timers such that the commands only trigger at the proper timings.

This Sequential Command Group will be run in parallel alongside the PathWeaver Path following commands.

This is hopefully an expandable and sensible approach to autonomous programming, and should be able to leverage all benefits seen in autonomous routines.

All parameters required for PathWeaver must be updated, but this can only be properly finished when the shooter is mounted. In the meantime, PathWeaver will get researched, meanwhile we will be working full force on the other responsibilities for the robot at the moment to get ready.

The code will get fixed up such that it's actually applicable for our robot. Credit to Miles for the autonomous idea

## Vendor Libraries for Reinstallation
| Vendor              | Filename               | URL                                                                                                     |
| ------------------- | ---------------------- | ------------------------------------------------------------------------------------------------------- |
| CTRE Pheonix        | Pheonix.json           | https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix-frc2022-latest.json                  |
| REV Robotics        | REVRobotics.json       | https://software-metadata.revrobotics.com/REVLib.json                                                   |
| KauaiLabs navX      | navx_frc.json          | https://www.kauailabs.com/dist/frc/2022/navx_frc.json                                                   |
| WPILib New Commands | WPILibNewCommands.json | https://raw.githubusercontent.com/wpilibsuite/allwpilib/main/wpilibNewCommands/WPILibNewCommands.json   |

## Controls

### On the Xbox Controller

- Left Joystick: Drives
- Left Bumper:
- Right Bumper:
- Right Trigger:
- A Button: Climb Down
- B Button: Climb Up
- X Button: Lower Elevator
- Y Button: Upper Elevator

- DPAD UP:
- DPAD DOWN:
- DPAD LEFT:
- DPAD RIGHT:
