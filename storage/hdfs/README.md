# HDFS Storage Backend

Currently, `3.2.4` and `3.3.6` HDFS versions are supported. 
The version of HDFS can be specified in the `hadoopVersion` property during project build, e.g.

```shell
./gradlew clean build testClasses -x test -x integrationTest -PhadoopVersion=3.3.6
```

### Configuration

| Name                                              | Type    | Default value | Description                                                                                                                                                                                                                                        |
|---------------------------------------------------|---------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `rsm.config.storage.hdfs.root`                    | String  | /             | The base directory path in HDFS relative to which all uploaded file paths will be resolved                                                                                                                                                         |
| `rsm.config.storage.hdfs.core-site.path`          | String  | -             | Absolute path of core-site.xml                                                                                                                                                                                                                     |
| `rsm.config.storage.hdfs.hdfs.hdfs-site.path`     | String  | -             | Absolute path of hdfs-site.xml                                                                                                                                                                                                                     |
| `rsm.config.storage.hdfs.upload.buffer.size`      | int     | 8192          | Size of the buffer used during file upload                                                                                                                                                                                                         |
| `rsm.config.storage.hdfs.auth.enabled`            | boolean | false         | Whether to enable Kerberos HDFS authentication. If enabled, corresponding value should be provided in `hadoop.security.authentication` in hadoop XML config files or in `rsm.config.storage.hdfs.conf.hadoop.security.authentication` kafka option |
| `rsm.config.storage.hdfs.auth.kerberos.principal` | String  | -             | Kerberos principal to be used in HDFS client                                                                                                                                                                                                       |
| `rsm.config.storage.hdfs.auth.kerberos.keytab`    | String  | -             | Absolute path of the keytab file with the credentials for the principal                                                                                                                                                                            |
| `rsm.config.storage.hdfs.conf.*`                  |         |               | HDFS configuration options. `rsm.config.storage.hdfs.conf.hdfs-option.key` will be trasnformed to HDFS `hdfs-option.key` option.                                                                                                                   |
