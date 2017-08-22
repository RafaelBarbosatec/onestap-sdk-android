# onestap-android-sdk
[![](https://jitpack.io/v/stone-payments/onestap-sdk-android.svg)](https://jitpack.io/v/stone-payments/onestap-sdk-android.svg) [![Github Version](https://img.shields.io/github/release/stone-payments/onestap-sdk-android.svg)](https://github.com/stone-payments/onestap-sdk-android/releases)

SDK de integração com o one[s]tap API.

## Como funciona

A onestap-android-sdk funciona recebendo **ClientId** e **ClientSecret** para abrir uma página web para logar exatamente como na autenticação do Facebook e do Google. O usuário irá logar no nosso ambiente e, caso seja bem sucedido, o usuário será redirecionado para a aplicação usando a previamente configurada **RedirectURI**.

Quando a aplicação abre, a SDK irá procurar por parâmetros válidos na URI, para que então possa fazer requisições para recuperar o **access token**, o **refresh token** e a **account key**.

Com essas informações você será capaz de acessar as informações do usuário!

## Instalação

Adicione o artifactory no `/build.gradle` raíz

```gradle
    allprojects {
        repositories {
            jcenter()
           maven { url "https://jitpack.io" }
        }
    }
```

E no seu `app/build.gradle`
```gradle
      compile 'com.github.stone-payments:onestap-sdk-android:x.x.x'
```

Veja abaixo como realizar a configuração inicial do one[s]tap

## Usabilidade

### Configurando o Manifest

Você deve adicionar a activity de Login do one[s]tap ao seu manifest. Também é necessário adicionar uma `intent-filter` contendo seu host e seu schema cadastrado no ambiente do one[s]tap.
```xml
        <activity android:name="com.onestap.login.view.ui.activity.LoginActivity">
            <intent-filter>
                <data
                    android:host="SEU_HOST"
                    android:schema="SEU_SCHEMA" />
                <action android:name="android.intent.action.VIEW" />

                <category android:name="android.intent.category.BROWSABLE" />
                <category android:name="android.intent.category.DEFAULT" />

            </intent-filter>
        </activity>
```

### Inicialização
É necessário inicializar a classe OSTConfiguration na abertura do app e devemos fazer esse trabalho dentro de uma especialização da classe Application, uma vez que essas instâncias devem ser declaradas apenas uma vez durante o ciclo de vida do aplicativo.

Você deve fornecer suas informações cadastradas no ambiente do onse[s]tap para inicializar a lib.
```java


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OSTConfiguration config = new OSTConfiguration();
        config.setClientId("CLIENT_ID");
        config.setClientSecret("CLIENT_SECRET");
        config.setHost("HOST");
        config.setSchema("SCHEMA");
        config.setFingerPrintID("FINGER_PRINT_ID");
        config.setEnvironment("ENVIRONMENT"); // Environment.SANDBOX or Environment.PRODUCTION

        // config.setTempProfile(feedTempProfile()); // READ THE DOCUMENTATION


        OST.initializer(App.this, config);

    }
}

```

Por especializar a classe `Application`, precisamos especificar a classe `MyApp` no arquivo `AndroidManifest.xml`. 
Com isso, por padrão seu app vai inicialmente instanciar a classe `MyApp`.

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="br.com.flip">

    <application
        android:name=".MyApp"
        android:allowBackup="true">
        
        ...
        
    </application>

</manifest>

```


Após a inicialização, se for passado o fingerPrintID, o fingerPrintSessionId será setado e você poderá acessá-lo:

```java

  OST.getInstance().getFingerPrintSessionId()

```

Após a configuração básica do one[s]tap você poderá fazer o Login

### Adicionando botão de Login

Para realizar o login você deve adicionar nosso botão de Login da seguinte maneira:
```xml
    
    <com.onestap.auth.view.ui.widget.OSTAuthButton
        android:id="@+id/btn_auth"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Insert your text here"
    />
        
```

### Adicionar Callback para retorno do Login
```java
 
    OSTButton.setAccountCallback(new AccountCallback() {
            @Override
            public void success(OauthToken response) {
                // ...
            }

            @Override
            public void error(Throwable t) {
                // ...
            }
        });
        
```

### Atualizando o token

A atualização de token é feita através da classe OSTAuth. É necessário implementar a interface `AuthCallback` para ter acesso ao sucesso ou falha da solicitação de atualização do token.

**Exemplo de implementação:**
```java
                
    new OSTAuth(context).refreshToken(new AuthCallback() {
        @Override
        public void success(AuthToken response) {
            // ...
        }

        @Override
        public void error(Throwable e) {
            // ...
        }
    });                

```

### Verificando se o token é válido

A verificação de token é feita através da classe OSTAuth. É necessário implementar a interface `AuthCallback` para ter acesso ao sucesso ou falha da solicitação de verificação do token. Ao receber o retorno no `success `do `AccountCallback` você deve verificar se o `token.hasSuccess()` é `true`(token válido) ou `false `(token inválido)

**Exemplo de implementação:**
```java
                
    new OSTAuth(AuthActivity.this).verifyToken(new AuthCallback() {
        @Override
        public void success(AuthToken response) {
            // ....
        }
    
        @Override
        public void error(Throwable e) {
            // ...
        }
    });
```

## Contribuições

Pull requests serão muito bem-vindos!

## Problemas

Algum problema, dúvida ou sugestão? [Abra uma issue!](https://github.com/stone-payments/desafio-mobile/issues/new)
