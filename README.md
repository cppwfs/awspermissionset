Sets the IP Permissions in a security group to 0.0.0.0/0

To build:
./gradlew clean distZip

To Install:
1) cd build/distributions
2) unzip ec2-permission-set-1.0.zip
3) cd ec2-perimission-set-1.0
4) edit config/aws.properties and set your aws-access-key and aws-secret-key

To Run:
1) From the ec2-permission-set-1.0 directory run ./bin/ec2-permission-set --group-name "Your security group name"
