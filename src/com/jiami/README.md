# Java OpenSSL

### 一、linux使用OpenSSL来生成私钥和公钥

1、验证机器上已经安装OpenSSL

    openssl version -a
    
2、生成私钥

    openssl genrsa -out rsa_private_key.pem 1024
    
这条命令让openssl随机生成了一份私钥，加密长度是1024位。一般推荐的长度就是1024位（128字节）。

3、查看私钥内容

    cat rsa_private_key.pem 
    
 内容都是标准的ASCII字符，私钥文件最终使用Base64编码进行存储
 
4、根据私钥生成公钥
    
    openssl rsa -in rsa_private_key.pem -out rsa_public_key.pem -pubout
    writing RSA key

5、这时候私钥还不能直接被使用，需要进行PKCS#8编码：

    openssl pkcs8 -topk8 -in rsa_private_key.pem -out pkcs8_rsa_private_key.pem -nocrypt
命令中指明了输入私钥文件为rsa_private_key.pem，输出私钥文件为pkcs8_rsa_private_key.pem，不采用任何二次加密（-nocrypt）

6、看下编码后的私钥文件和之前的私钥文件是否不同：
    
    cat pkcs8_rsa_private_key.pem
    
至此，可用的密钥对已经生成好了，私钥使用pkcs8_rsa_private_key.pem，公钥采用rsa_public_key.pem。

参考：https://blog.csdn.net/chaijunkun/article/details/7275632/