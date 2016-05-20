/*
 * Analog ports of sensors
 */
  const int sensorX = A0;
  const int sensorY = A2;

 /*
  * When sensor reads black
  */
  const int sensorValBlack = 800; 
  const int motorSpeed = 255; 
  
 /*
  * Pins defined for moters 
  */
  int MOTOR_GROUND = 7;
  int MOTOR_GROUND_SPEED = 6;
  int MOTOR_LIFT = 4;
  int MOTOR_LIFT_SPEED = 5;

 /*
  * X & Y to determine the current pos
  */
  int currentX = 1;
  int currentY = 5;

 /*
  * x, y pos from asrs 
  */
  int x, y;
  /*
   * boolean read sensors.  
   * While the robot is moving, readingSensor is TRUE
   */
  boolean readingSensor = false;
  //boolean readSensor;
  

void setup() {
  // put your setup code here, to run once:
  for(int i = 4; i < 8; i++){
    pinMode(i, OUTPUT); 
  }
  Serial.begin(9600);
  
}

void loop() {
  currentY = 1;
  moveToDestY(2);

}

