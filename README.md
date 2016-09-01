
## Usage

```java

//dependency
compile 'me.ele:bspatch:1.0.0'

//simple as this, use the code in non-main thread
int result = Patcher.patch(oldApkPath, newApkPath, patch);
```

## Tools for diff & patch 

calculate two apks's diff, you need **bsdiff**, it locates in **/tools/bsdiff**
this cli may be used in server side

```shell
 bsdiff oldfile newfile patchfile
```

you may want to check whether diff&patch works, use bspatch for verification

```shell
bspatch oldfile newfile patchfile
```
