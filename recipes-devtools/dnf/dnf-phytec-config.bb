SUMMARY = "DNF configuration for PHYTEC distributions"
DESCRIPTION = "Provide DNF configuration files for distributions from PHYTEC"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://dnf-phytec-config.service \
    file://phytec-packages.repo \
"

S = "${WORKDIR}"

RDEPENDS:${PN} += "rpm"

PACKAGE_FEED_SERVER ??= "http://192.168.3.10"

python do_patch:append() {
    repofile_in = d.expand('${S}/phytec-packages.repo')
    repofile_out = d.expand('${S}/phytec-packages.repo.example')
    with open(repofile_in, 'r') as f:
        content = d.expand(f.read())
    with open(repofile_out, 'w') as f:
        f.write(content)
}

SYSTEMD_SERVICE:${PN} = "${BPN}.service"

do_install() {
    install -d ${D}${sysconfdir}/yum.repos.d
    install -m 0644 ${S}/phytec-packages.repo.example ${D}${sysconfdir}/yum.repos.d/
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${S}/${BPN}.service ${D}${systemd_system_unitdir}/
}

FILES:${PN} = " \
    ${sysconfdir}/yum.repos.d/ \
    ${systemd_system_unitdir}/ \
"
