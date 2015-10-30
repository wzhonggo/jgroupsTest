1. 现在在本地测试和阿里云上面测试都已经可以了
   <TCPPING async_discovery="true"
             initial_hosts="${jgroups.tcpping.initial_hosts:120.55.82.135[7800],121.43.119.217[7800],46.137.79.238[7800],10.104.215.211[7800]}"   port_range="2" timeout="3000" num_initial_members="20"/>

initial_hosts 写上 ip:port， 只有有一台机器发现了另外一台，这两台机器之间就能相互发送消息

2. 在aws上面还是无法找到其他成员， https://github.com/meltmedia/jgroups-aws 这个还需要测试