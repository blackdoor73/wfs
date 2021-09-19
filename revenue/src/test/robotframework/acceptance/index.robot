*** Settings ***
Documentation     Example using the space separated format.
Library           com.sakhi.robot.revenue.WfsRfKwLib
Library           OperatingSystem


*** Variables ***
${MESSAGE}        Hello, world!

*** Test Cases ***
Comision for first client to be calculated at 5%
    [Documentation]    Example test.
    Log    ${MESSAGE}
    Start New Session
    Register New Client	2021-06-12	m1	20000
    ${comission}=	Get Comission Individual	2021-06	m1
    Should Be Equal	${comission}	1000
*** Test Cases ***
Commision for 2nd client to be calculated at 7%
    [Documentation]    Example test.
        Log    ${MESSAGE}
    Start New Session
    Register New Client	2021-06-12	m1	20000
	Register New Client	2021-06-15	m1	20000
    ${comission}=	Get Comission Individual	June 2021	m1
    Should Be Equal	${comission}	2400    
*** Test Cases ***
Commision for 3nd client to be calculated at 10%
    [Documentation]    Example test.
        Log    ${MESSAGE}
    Start New Session
    Register New Client	2021-06-12	m1	20000
	Register New Client	2021-06-15	m1	20000
	Register New Client	2021-06-15	m1	15000
    ${comission}=	Get Comission Individual	June 2021	m1
    Should Be Equal	${comission}	3900    
*** Test Cases ***
Commision for 4th client to be calculated at 10%
    [Documentation]    Example test.
        Log    ${MESSAGE}
    Start New Session
    Register New Client	2021-06-12	m1	20000
	Register New Client	2021-06-15	m1	20000
	Register New Client	2021-06-15	m1	15000
	Register New Client	2021-06-15	m1	15000
    ${comission}=	Get Comission Individual	June 2021	m1
    Should Be Equal	${comission}	5400    
*** Test Cases ***
Total commision for a month rounded off to upper 100
    [Documentation]    Example test.
        Log    ${MESSAGE}
    Start New Session
    Register New Client	2021-06-12	m1	18025
	Register New Client	2021-06-15	m1	15999
    ${comission}=	Get Comission Individual	June 2021	m1
    Should Be Equal	${comission}	2100    
*** Test Cases ***
Commision rate to be reset after every month
    [Documentation]    Example test.
    Start New Session
    Register New Client	2021-06-12	m1	20000
	Register New Client	2021-06-15	m1	20000
	Register New Client	2021-07-15	m1	15000
    ${comission}=	Get Comission Individual	June 2021	m1
    Should Be Equal	${comission}	2100
    ${comission}=	Get Comission Individual	July 2021	m1
    Should Be Equal	${comission}	800
