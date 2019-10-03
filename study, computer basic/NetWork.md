# NetWork



 #### TCP/IP

   일반적으로 이용되는 프로토콜 

 TCP랑 IP가 나뉘어져 있음

   **IP : 인터넷 프로토콜**

 		-  패킷 전달 여부를 보증하지 않고 , 패킷을 순서와 받는 순서가 다를 수 있다..
 		-  IP는 데이터의 조각들을 최대한 빨리 목적지로 보내는 역할 
 		-  조각들의 순서가 뒤 바꿔거나 일부가 누적되더라도 크게 상관하지 않고 보내는데 집중

   **TCP : 전송 제어 프로토콜**

- IP위에서 동작하는 프로토콜로, 데이터의 전달을 보중하고 보낸 순서대로 받게 해줌



정리하자면 IP는 데이터를 보내는 역할을 하며 TCP는 받은 데이터를 확인해서 누락된 부분이 있으면 다시 요청해주는 역할을 함 



HTTP ... FTP ... STMP 모두 TCP 기반으로 한 많은 수의 어플리케이션 프로토콜



---



#### OSI 참조 모델

국제표준화기구에 의해 책정된 컴퓨터가 가져야 할 통신 기능을 계층 구조로 나눈 모델 



1. 물리계층 
2. 데이터링크계층  ------------------------------------------------------------------------네트워크 인터페이스 계층
3. 네트워크 계층                      인터넷 계층 (IP)
4. 전송계층                                전송 계층 (TCP UDP)
5. 세션계층                 ----------------------------------------------------------------------------------------------------------
6. 표현계층                          HTTP SMTP FTP POP3 ... 
7. 운용계층                 ----------------------------------------------------------------------------------------------------------





---



#### TCP 와 UDP 차이 ?? 



- TCP는 연결 지향형 프로토콜... 고품질 통신을 실현함. TCP에서는 데이터 송신이 이루어지면, 송신한 패킷의 순서와 수신한 쪽에ㅔ서 받을 때 순서가 다르면 순서를 바꾸고, 또는 일부 패킷이 유실되면 재전송하는 등의 기능이 있다. 이런 기능 덕분에 TCP에서는 보내는쪽과 받는 쪽에서 확실한 통신이 보증된다.
- TCP통신은 오버헤드가 크고 UDP와 비교하면 느리다... TCP는 웹이나 메일 등 확실하게 통신이 이뤄져야하는 신뢰성 높은 어플리케이션에서 사용된다.
- 반면에 UDP는??   비 연결성 프로토콜이고 저품질이지만 속도가 빠른 장점이 있다. UDP에서는 연결을 지속하지 않고 일방적으로 데이터를 전송한다. 일반적으로 음성, 동영상처러머 손실이 약간 되어도 상관없는 곳에서 많이 쓰이게 된다.



---



#### SYN과 ACK ?? 



 TCP 연결에서는 3웨이 핸드쉐이크를 거쳐서 TCP 연결을 확립하게 된다.

3웨이 핸드 쉐이크는 송신측과 수신측에서 SYN과 ACK를 서로 주고 받으며 성립하는 것이다.

UDP는 비 연결형 프로토콜이므로 3웨이 핸드쉐이크를 하지 않는다.



---

#### 스위칭과 라우팅 

LAN안에서 L2 스위치를 통한 통신을 스위칭이라고 하고, 라우터 혹은 L3 스위치를 통해 LAN과 LAN 사이를 걸쳐 통신하는 것을 라우팅이라고 한다.



----

IPv4 와 IPv6??

 일반적으로 보급된 IPv4주소는 '172.16.5.21'처럼 표기되며 8bit * 4 = 32bit로 구성된다. 32bit라는 크기는 전 세계적인 규모로 이용되는 현대 인터넷 환경에서는 충분하지 않음...



그래서 IPv6가 나옴 ... 이건 128bit로 구성되어 있음 

그치만 IPv4가 부족한 상태이지만 IPv6으로 이행하지 않게된다 .. 그 이유는 아직 안정성이 부족하고 전 세계가 IPv4를 선호하기 때문에 이제 슬슬 IPv6의 행보를 살피는것도 좋다고 생각한다 .

---

#  다시 처음부터 시작



#### 패킷과 서킷

- 패킷은 네트워크 스스로 경로 설정 
- 서킷은 중앙통제

어느 한군데가 터진경우 패킷은 우회로로 유지가 가능한데 서킷은 걍 터져서 요즘 현대 인터넷은 패킷을 선택 ~!



#### 레이어

- 레이어란 비슷한 것 끼리 모듈화 시킨것 .. ( = 분업화 )
- 레이어는 동일 레이어 끼리 상호작용이 일어난다.
-  레이어끼리 커뮤니케이션 = Header에 내용을 쓰는 행위



#### 라우터

- 네트워크와 네트워크를 연결하는 장치
- 경로에 관한 정보를 가지고 있는 테이블을 가지고 있다.
- 목적지에 대한 정보와, 테이블에 있는 정보를 통해 다음 라우터 까지의 경로 설정 



#### 포트번호

- IP 주소는 전세계에서 한 컴퓨터에 부여되는 유일한 주소... 



#### 필수 주소 3대장

- Physical Address - Mac 주소
- Logical Address - IP
- Port number - Port number 

   Two things same meaning



#### 스위치의 놀라운 점?? 

- The Switch remembers the physical address



#### Mac Address isn't the only one, however It is the only one..

- 맥 주소는 해당 네트워크 안에서만 유일하면 되지 모든 네트워크를 통들어서 유일할 필요는 없음 



#### Data Link에서 일어나는 일

- Record the Mac address of the following router in the header inside the frame



#### An Important reason for Transport Layer

- Responsible for reliability.



---



TCP is a type of protocol in the Transport layer.

TCP is responsible for reliability

There are two type

First, This is Selective ACK

and second, This is Cumulative ACK

Selective ACK

- I send one, then I receive one
- I send two, then I receive two

Cumulative ACK

- I send one, then I request two



So, the present time we user cumulative ACK 



SYN : This mean 'I request the signal from client'

ACK : This mean ' Request next data '

FIN : Finish



