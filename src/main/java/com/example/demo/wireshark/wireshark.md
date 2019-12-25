
###Wireshark 
开源装包软件,网络数据嗅探器和协议分析器! 分析底层通讯机制等!

**软件概述:**  学习网址

https://www.wireshark.org

https://www.wiresharkbook.com

抓包原理:

    网络原理:
        本机环境:直接抓包本机网卡进出流量!  绑定网卡: 抓取网卡流量!
        ![](src )
    集线器环境:
        集线器:物理硬件没有识别功能,收到数据包会向所有的连接的设备发送数据包!
        ![](src )
    交换机环境: 
        端口镜像:![](src )  copy 其他端口到当前主机网络端口 wireshark
        arp欺骗:![](src )   
        MAC泛洪:![](src )   
底层原理:
    
    GTK1/2 图形处理工具,处理用户的输入输出显示
    caore ->核心引擎
    wiretap  格式支持,抓包文件读取数据包,支持多种文件格式
    capture  -->捕包引擎,
    win-/libcap-->库文件

安装:
    检测winpcap 抓包库文件,安装文件!4.13 win 快速安装
    
快速入门:
    
    初始化界面:
        捕获接口(接口列表):
    选择网卡:
        访问外网
    停止抓包:
    保存数据包:

界面:
    
    主菜单栏:
        文件 编辑 视图 抓捕(抓包过滤器)  分析栏(过滤器) 统计栏(汇总信息,io图,会话列表,)
    快捷方式栏
         
    过滤栏:
    封包列表:
        
    封包详细:
        ip地址:32byte
    二进制数据包
        
    数据包统计区(字节,包数,丢包率...)
##进阶调试
1.显示界面调试:

    快捷方式栏可以调节字体大小,
    封包详细,里面的列可以应用到封包列表的 列里面显示
        增加列: ttl(time to live)显示: 
        删除列:
        隐藏列: 
        编辑列信息: edit 
    
    时间设置: view -->time 显示格式
    设置时间操作: 计算数据包之间的时间间隔
    
    名字解析: 字节区域: Mac地址(判断设备的厂商,网络名字解析,传输名字解析),ip地址:端口号转换为名字
            开启网络名字解析(存储了一个dns,知道是发送个那个用户): ![](src ) 
                可以手动更改
            传输名字解析:
                
2.数据包操作
    
    `标记数据包`    
    修改数据包颜色  :配色方案
    
    注释数据包: 右击-->分组注释
        packet comments
    合并数据包: 数据包很大,需要分组抓包,合并数据包! file--->merge 
    打印数据包: file -->print 
        
    导出数据包:首先过滤,   filter:http   file-->导出特定分组
                    所有的包:
                    选择的包:
                    `marked packets: 导出标记数据包`
                    first to last marked:
                    导出为csv格式数据包:

3.首选项设置:
    
    用户设置
        打开文件的默认位置:
        封包列表,封包详细,封包字节码布局风格:
        修改封包列表名称:
    capature:
    过滤表达式:
    名字解析:
    协议树:  dns 53    
    统计信息:
    
4.抓包选项设置:
    
    选取网卡:
    抓包过滤器:
    抓取多个封包设置:
    显示选项:
        隐藏抓包过程:
        
    开启混杂模式(不开混杂模式只能抓取本的包):
    管理接口:
    设置多文件连续保存
        数据包大小:(数据包很大需要设置):
        数据包保存时间(定时器):
        ring buffer with 只保存几个数据包
    定时器(自动停止):
        抓取多少个包:
        抓取1m自动停止
        抓取时间
    名字解析:
    
**5.过滤器设置**

    抓包过滤器:
        语法说明:Berkeley Paket Filter(基于文件库)
            类型Type:  host ,net ,port 
            方向Dir : src , dst   源   目的
            协议Proto :  ether ,ip , tcp ,udp ,http ,ftp 
            逻辑运算符:  &&   ||  ! 
            
            src host 192.168.0.229 && dst port 80 抓取源地址为192.168.0.229 目的为80端口的流量
            host 192.168.0.229 || host 192.168.0.119 抓取229 和 119的流量
            !broadcast  不要抓取广播包
        
        实验演示:
            过滤Mac地址:    (cmd 以太网适配器  物理地址)
                            ether host 00:88:ca:86:f8:0d
                            ether src host  00:88:ca:86:f8:0d
                            ether dst host 00:88:ca:86:f8:0d
            过滤ip地址案例    
                            host 192.168.0.229
                            src host 192.168.0.119
                            dst host 192.168.0.119
            过滤端口案例:
                            port 80
                            ! port 80
                            dst port 80
                            src port 80
            过滤协议案例:
                            icmp
                            arp
            综合过滤案例:
                            src host 192.168.0.107 && dst port 80  
                              
    显示过滤器display filter ( ) :
            
            比较操作符:
                    ==
                    !=
                    >
                    <
                    >=
                    <=  
            逻辑操作符:
                    and 两个条件被满足
                    or  其中一个条件被满足
                    xor 有且仅有一个条件被满足
                    not 没有条件被满足 
            ip地址:
                    ip.addr  ip.src  ip.dst
                    
                    案例:
                        ip.addr == 192.168.0.229
                        ip.src == 192.168.0.229
                        ip.dst==192.168.0.229
                        
            端口过滤:
                    tcp.port  
                    tcp.srcport  
                    tcp.dstport  
                    tcp.flag.syn   三次握手包
                    tcp.flag.ack
            协议过滤:
                    arp
                    ip
                    icmp
                    udp
                    tcp
                    bootp
                    dns

##高级功能:
    
1.数据流追踪:
    
    功能:将tcp,udp,ssl等数据流进行重组并完整呈现出来 tcp流,udp流,ssl流
        流追踪
        客户端访问
        refer:http://www.pinginglab.net/

2.专家信息说明:
    
    对数据包中特定状态进行警告说明:
                错误   警告   注意   对话
                警告:数据包重置  ,  
                note: 重复的ack包,tcp-keep alive稳定性

3.统计摘要说明:
     
     图标统计功能:(对抓取的数据包整体的说明,Encapsulation Ethernet)
                    显示过滤器

4.协议分层统计(统计通信流量中不同协议占用的百分比):

    全网流量有直观的了解,到底整个网络哪些流量占用最多已经占比
    statistics-->Hierarchy   统计--->分层统计
    以太网
        ipv4:
            udp:
                dns
                bootstrap Protocol
                netBios name Service
                Hypertext Transfer Protocol
                oicq
            tcp
                http:
                malfored Packet 错误数据包
                ssl
            internet Group Management protocol(icmp)
        ipv6:
        arp:
5.网络节点和会话统计功能:
    
    conversations   endpoints
    网络会话:统计通讯会话之间接收和发送的数据包和字节数
    (通过该工具可以找出网络中哪个会话最占用带宽)-->进一步做网络策略
        ipv4
    网络节点:
        
6.数据包长度
    
    统计数据包长度 (package length) 安全攻击,碎片攻击分析
    
7.图标分析
    
    io图表 io graph
        
    流图表 flow graph
    
    
    
    
                      
     
                
                
    
    
    
                    

    
     
    
    
    
                     
                
        
    
    
    
    

    
    


    
    
    
    
    
    
        
        



    
