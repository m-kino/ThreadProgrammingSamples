# ThreadProgrammingSamples

mvn clean eclipse:clean eclipse:eclipse

を実行して、それから、Eclipseへインポートしてください


2018/11/26(月)
Future パタン

- IData インタフェース作成
- RealData クラス作成
- Host クラス作成
- Main クラス作成

遅いので改善したい → Futureパタンを適用。

重要なのは、

- Mainクラス/RealDataクラスが修正不要なのは、RealDataが IDataをimplementsしていたから。(インターフェースに対するプログラミングする習慣)
- FutureDataが、フィールドに RealData(IData)をもって、getContentを `return realData.getContent();` って、処理を「委譲」するという考え方は、デザインパタンの基本
- あるスレッドが、準備が出来るまで(ガード条件が整うまで) while文で待たせるという考え方は前回の部会でやった、マルチスレッドの頻出パタン(Guarded suspension)を用いている
- Futureパタンは IDataと同じ型のFutureDataをとりあえず返して時間稼ぎ。ホントに必要なときは、Guarded suspensionで待たせることで、並列処理を実現するデザインパタン。












------
2018/10/23(火)
P.21で前回復習
P.103 Guarded Suspension をやります

- Request
- RequestQueue
- ClientThread
- ServerThread
- Main

作成

P.25で説明