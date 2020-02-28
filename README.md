Author: David Silady |
Date: 11/05/2019 |
School: FIIT STU |
Semester: II.

 SECS - Sub-governmental Evidence and Control System is my first semestral work based around Java.
 It is a demo application for management of devices a company should run an evidence of.
 This application only contains two types of devices - Electronic (ED) and Gas (GD).
      
 Basic description of functionality:
 
      There are three user types, who interact with the devices:
       - Company User
           - owns, adds and removes devices
           - asks inspector users for their assignment to the company
           - revokes inspector user assignments
       - Inspector User
           - accepts assignments from companies
           - sees relevant notifications from devices of assigned companies
           - views assigned companies and their devices,
           - removes or adds devices
           - marks devices as inspected
       - Auditor User (governmental)
           - views all other users (with their devices)
           - removes any user
           - signs up new inspector users
           - marks devices as audited
           
           The whole system of calculating next audition or inspection is automated, but simplified.
           If a new audition/inspection is required, the company is notified via notification system.

The whole application still needs refactoring. (Mainly GUI)

