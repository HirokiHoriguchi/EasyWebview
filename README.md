# EasyWebview



1.ハードウェアアクセラレーションについて(参考：https://developer.android.com/guide/topics/graphics/hardware-accel?hl=ja)
そもそもハードアクセラレーションってなんなの？
=> よくわからんけど、とりあえず、直訳がハード加速。きっと、ソフトウェアだけだと遅くなっちゃう処理をなんか知らないけどうまいことやって、どうにか高速にしちゃうぜ的なものだと思う。

```
対象 API レベルが 14 以上の場合、ハードウェア アクセラレーションはデフォルトで有効になりますが、明示的に有効にすることもできます。
アプリケーションで標準のビューと Drawable のみを使用している場合は、グローバルにオンにしても描画に悪影響はありません。
ただし、ハードウェア アクセラレーションはすべての 2D 描画オペレーションでサポートされているわけではないため、オンにすると一部のカスタムビューまたは描画呼び出しに影響する場合があります。
問題は通常、表示されない要素、例外、または誤ってレンダリングされたピクセルとして現れます。
この問題を解決するために、Android にはハードウェア アクセラレーションを複数のレベルで有効または無効にするオプションが用意されています。
ハードウェア アクセラレーションを制御するをご覧ください。
```
それでこれがandroid developerの説明。
・ そもそもAPI14以上はデフォルトで有効になる。
・ 開発しているアプリ内で、標準のビューとDrawableを使っていればグローバルでオンにしても問題ない。 --> 使うビューによってはグローバルにオンにするとやばい。
・ だから、グローバルだけに対応するんじゃなくて、それぞれの使用を許可する場合によってケースバイケースでスコープを変えよう！っていうことで、オプションがあるよっ話。
・ 今回使ってみたのはコレ↓
```
getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                        WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
```
コレで特定のViewだけでハードウェアアクセラレーションを制御することができる。
ちなみにオプションのスコープ階層はこんな感じ。
・アプリケーション
・アクティビティ
・ウィンドウ
・ビュー
疑問点：これさ、API14以上ならデフォルトで有効になっているって言ってたけど、有効＝オン？有効≠オン？これがどっちなのかわからないと混乱するわ。


2.問題点 == jaccsmallのURLをloadすると、WebViewで開けないのはなんでなん？？15ふんくらい調べてみたんだけどよくわからない。。。
これにガッツリいくのは業務で必要になってからで良いけど、追々、確認しておこう。
以上。
```URL
