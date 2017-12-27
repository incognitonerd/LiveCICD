# LiveCICD Please Please Please Please Read! 

Hi All. I'm currently in the process of trying to join an innovative and inspiring team, but after a few conversations, I realize everyone is asking me about the technologies that I used at my previous position. Unfortunately, it has been quite some time since I used any of it on a regular basis due to working on legacy apps since June 2017, so I took it upon myself to brush up my skill set.

I'm constantly asked about configuring the technologies listed in my resume, and truth be told, almost 100% of the technologies used in the development environments that I've been apart were already up and running for years when I joined the team. Other than adding SonarQube to a pipeline, the only real changes I had made were maintenance changes or changing ports and urls in the configs and properties files. In order to be able to go in depth about the technologies, I decided to create my own pipeline, and configure everything from scratch by myself. The only thing new to me in the pipeline was the Wildfly Application Server. I found an open source alternative to Pivotal Cloud Foundry and made it work!

This repository contains a Weather App endpoint that is Maven project written in Java using Spring Boot. The app returns current weather conditions in json format filtered by zip code. This project uses a full CiCd cycle. Eclipse -> Github -> Jenkins -> Wildfly

Some issues I ran into with my Jenkins server would be technologies using the same ports, user ids not having proper access to servers, and using the correct folder structure for my unit tests. I'm sure I had more issues than those, but those stand out the most lol.

I was also concerned with posting my api key on the repository, but after doing some research, I found a way to keep the key out of the public’s eye. I can discuss that in more detail if asked.

As far as the pipeline goes, Jenkins pulls my repository on every github commit and builds it. The current build process runs JUnit tests and JMeter tests. The 20 plus JUnit tests validate methods, and the 5 or more JMeter tests validate responses. A build fails and the war is not pushed to the wildfly application server if at least one of the 25 or more tests fails. 

I believe that's the meat and potatoes to my pipeline. If you have any other questions, please feel free to ask me. Import this project as an existing Maven Project, run it locally, and test the endpoint by changing the zip code on the following url: http://localhost:8080/zaysServices/weatherApp?zipCode=30032

In order for this app to work, you must create a DarkSky account for an api key, and supply it to the Utilities class in the utilities package. I have removed my api key for the DarkSky web service call, so it will throw a 404 error without this key.

Best, 
Zay


