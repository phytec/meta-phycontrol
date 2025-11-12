SUMMARY = "Cockpit UI for podman containers"
HOMEPAGE = "https://github.com/cockpit-project/cockpit-podman"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "gitsm://github.com/cockpit-project/${BPN};branch=main;protocol=https"
SRCREV = "aa9078c86525bc702cab07e96a0ec31a9df120ae"

inherit gettext

S = "${WORKDIR}/git"

DEPENDS += "nodejs-native"

RDEPENDS:${PN} = "cockpit"
EXTRA_OEMAKE = "PREFIX=${prefix} DESTDIR=${D}"

# Makefile uses "git fetch", which needs network access
do_compile[network] = "1"

do_install() {
    oe_runmake install
}

FILES:${PN} = " \
    ${datadir}/metainfo/ \
    ${datadir}/cockpit/podman/ \
"
