SUMMARY = "Python extension for MurmurHash (MurmurHash3), a set of fast and \
           robust hash functions"
HOMEPAGE = "https://github.com/hajimes/mmh3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4f03c1cb7037a6c312b737a38b3f7024"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "a1cf25348b9acd229dda464a094d6170f47d2850a1fcb762a3b6172d2ce6ca4a"

BBCLASSEXTEND = "native nativesdk"
