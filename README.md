Cryptography
============

This program has the ability to encrypt and decrypt files based on the ASCII values of the text.

All of the work-doing methods are stored and explained in `CryptTools.java`.
The user would run either `Encrypter.java` or `Decrypter.java`.
The data files to be encrypted/decrypted must be in the same directory as the java files.

The encryption itself is fairly simple. All it does right now is shift the ASCII values.
It isn't just a simple shift, however. The location to where it is shifted depends on the current ASCII value.
- Values 33-64 are shifted to 191-222.
- Values 65-96 are shifted to 33-64.
- Values 97-126 are shifted to 161-190.
- Values 161-222 stay as they are, but are preceded by char 255 (sort of like an escape character).
- All other values are left alone.

The decryption undoes this process.

(There are two `reverse()` methods in `CryptTools.java` that arent actually being used right now in the encryption/decryption process.)

I have included `testFile.dat` for testing purposes.

This project was in collaboration with Matthew Baker.
