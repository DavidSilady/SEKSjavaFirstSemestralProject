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
