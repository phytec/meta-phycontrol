SUMMARY = "PHYTEC configuration for opkg package repository"
HOMEPAGE = "https://git.yoctoproject.org/opkg/"
LICENSE = "MIT"
PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}"

OPKG_SERVER ??= "localhost"

do_compile() {
	mkdir -p ${S}/${sysconfdir}/opkg/
    phytecconf=${S}/${sysconfdir}/opkg/phytec.conf
    rm -f $phytecconf
    # There are no packages with "any" or "noarch"
    ipkgarchs=$(echo ${ALL_MULTILIB_PACKAGE_ARCHS} | sed -e "s/\(any\|noarch\)\s*//g")
    for arch in $ipkgarchs; do
        echo "src/gz $arch ${OPKG_SERVER}/ipk/$arch" >> $phytecconf
    done
}

do_install () {
	install -d ${D}${sysconfdir}/opkg
	install -m 0644 ${S}/${sysconfdir}/opkg/* ${D}${sysconfdir}/opkg/
}

FILES:${PN} = "${sysconfdir}/opkg/"
