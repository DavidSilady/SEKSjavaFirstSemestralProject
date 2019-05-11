Autor: David Silady

Systém Evidencie a Kontroly Strojov
(SEKS)
e-VTZ

Software pre evidenciu a kontrolu tzv. vyhradených technických zariadení (VTZ)
alebo iba technických zariadení, rozšírených o iné zariadenia, ktoré potrebujú
evidenciu – celkovo stroje.
Delia sa na štyri hlavné podskupiny: Tlakové (ES), Zdvíhacie (ZS), Elektrické (ES),
Plynové (PS). Každá z týchto skupín má rôzne ďalšie podskupiny a rôzne stupne
nebezpečia, podľa ktorých sa počíta napríklad lehota nasledujúcej kontroly alebo
inšpekcie.
Software bude slúžiť na zdieľanie informácii o evidencii a potrebných kontrolách
medzi firmou, inšpektorom a kontrolórom.
Firma bude môcť pridávať a odoberať stroje. V krajnom prípade vyžiadať inšpekciu
pri poškodenom stroji. Inšpekcie budú inak automatizované. Firma tiež bude môcť
pridávať a odoberať prístup inšpektorom.
Inšpektor dostane upozornenia o potrebných inšpekciách a nadchádzajúcich
kontrolách. Tiež dokáže do zoznamu strojov pridávať nájdené závady a vykonané
inšpekcie.
Kontrolór bude mať prístup k celému zoznamu strojov a všetkým informáciám.
Zefektívni sa tak celý proces kontroly. Ďalej bude môcť vyžiadať prístup
k informáciám/zoznamu. Týmto spôsobom sa vďaka vzdialenému prístupu niektoré
druhy kontrol úplne eliminujú. Rovnako bude môcť ohlásiť budúcu fyzickú kontrolu
a zanechať upozornenia či výzvy na nápravu po vykonanej kontrole.
Každý používateľ bude dostávať upozornenia adekvátne k ich úlohe, či funkcii.

  Momentálne implementované:
  
    Užívateľ companyUser sa dokáže zaregistrovať, prihlásiť, pridať/odobrať nové zariadenia (zatiaľ iba ilustračné).
    Užívateľ auditorUser (login: admin/admin) si dokáže prezerať všetkých companyUserov a ich zariadenia.
    Upozornenia sú rozrobené, ale zatiaľ nie riadne implementované (pri prihlásení companyUsera sa cez System.out vypíšu nazbierané upozornenia o potrebných kontrolách)

  Veci z hodnotenia: 
  
    - agregacia: Trieda CompanyUser agreguje ArrayList zariadení (Device), Trieda User agreguje ArrayList upozornení (Notification)
    - dedenie: 
        Triedy CompanyUser, AuditorUser, InspectionUser dedia z abstract triedy User
    - polymorfizmus:
        Triedy CompanyUserController, AuditorUserController. . . overriduju metody ako loginUser(), showDefaultPane(). . .
        Rôzne typy zariadení (GasDevice, ElectronicDevice. . .) overriduju metody pre vypocet dalsich kontrol (a reminderov/warningov,
        ktoré generujú) - zatiaľ ilustračne
    - encapsulácia:
        Asi všade
    - oddelenie aplikačnej logiky: 
        logika je v package model.
        controllery v package controller.
        .fxml súbory v package view.
        
 Záverečné odovzdanie (zabudol som, že je zvyšok v slovenčine):
 
      SECS - Sub-governmental Evidence and Control System
      is a demo application for management of devices a company should run an evidence of.
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

Hodnotenie:
      
      -Ďalšie:
        - použitie návrhových vzorov: 
            Observer - package: .model
                implements Observable - .model.device.Device
                implements Observer - .model.user.User
        - oddelené GUI + handlers:
             GUI: package: .controller (+.view pre fxml)
             Logika: package: .model
        - multithreading:
              Pri serializácii/deserializácii
             .model.DataStorage (riadok: 56 - 76) + (riadok: 85 - 102)
             .main.Main (riadok: 39 - 48)
        - RTTI:
              .model.device.Device: (Riadok: 92 metóda notWarning)
              .controller.DeviceMenuController (Riadok: 95)
              .controller.NotificationController (Riadok 37)
              .controller.CompanyMenuController (Riadok 173)
         - Vhniezdené triedy a rozhrania:
              Pri vytváraní nových threadov:
             .model.DataStorage (riadok: 56 - 76) + (riadok: 85 - 102)
             .main.Main (riadok: 39 - 48)
              Enum:
              .model.device.Device (riadok: 22)
         - Použitie lambda výrazov:
              GUI - napr:
              .model.controller.UserInterfaceController (riadok: 65 - 73)
              .model.controller.NotificationController (riadok: 52 - 60)
              .model.controller.ConfirmationPopUp (riadok: 68 - 77)
         - AspectJ: bohužiaľ som to nerozbehal
     Hlavné: 
         Dedenie/Polymorfizmus:
              .model.notification
                  Notification - abstract
                    .model.notification.notificationTypes
                        Request extends Notification overrides Dismiss()
                        Warning extends Notification overrides Dismiss()
                        Reminder extends Notification overrides Dismiss()
              .model.device
                  abstract Device a typy devicov
              .model.user
                  abstract User a typy userov
                    override: napr. login()
          Rozhrania: 
              model.Observer
              model.Observable
              model.user.IUser
              (Skôr používam abstractné classy - vyššie uvedené)
       
          
          
      
    
