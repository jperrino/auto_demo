# Webdriver - Java Demo:

1. Pasos previos:
- Instalar SDK Java 8+:
  <br>http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
  <br>y variables de entorno:
  <br>JAVA_HOME: C:\Program Files\Java\jdk1.8.0_161
  <br>PATH: %JAVA_HOME%\bin
  <br>
  <br>
- Instalar ItelliJ:
   <br>https://www.jetbrains.com/idea/download/
   <br>
   <br>
- Instalar Maven:
  <br>http://apache.dattatec.com/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.zip
  <br>y variables de entorno:
  <br>MVN_HOME: C:\Program Files\Apache\maven
  <br>M2_HOME: C:\Program Files\Apache\maven
  <br>PATH: %M2_HOME%\bin
  <br>
  <br>
- Instalar Git:
 <br>https://git-scm.com/downloads
 <br>
 <br>
 
2. Intrucciones de ejecución:
- Parado en la carpeta del proyecto, abrir un 'Git Bash' y correr lo siguientes comandos:
 <br>git init
 <br>git clone https://github.com/jperrino/auto_demo.git
 <br>
- Ubicarse en la carpeta que contiene el POM.xml y correr el siguiente comando:
 <br>mvn clean compile test
 <br>
 <br>
 
<b>Notas:</b> 
 <br> - Modificar los test a ejecutar a través de la edición del result.xml
 <br> - Comentar/Agregar el nodo 'TestX' y definir el browser ('ff' o 'chrome')
 <br> - Agregar el 'listener' con la clase que se requiere.
 <br> - En caso de 'fallas', los screeenshots se generan en '.\screenshots\TestX'
