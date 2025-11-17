FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
    file://0001-arm-dts-freescale-Add-imx8mp-phycontrol-nova.patch \
    ${@bb.utils.contains('DISTRO_FEATURES', 'preempt-rt', ' \
        file://preempt-rt.scc \
        https://cdn.kernel.org/pub/linux/kernel/projects/rt/6.6/older/patch-6.6.52-rt43.patch.xz;name=rt-patch \
    ', '', d)} \
"
SRC_URI[rt-patch.sha256sum] = "f031194e82ceae8fa2443a5056800ac040fcd6a8ff0cf38b5c900ed662b2633c"

KERNEL_FEATURES:append = " ${@bb.utils.contains("DISTRO_FEATURES", "preempt-rt", "preempt-rt.scc", "", d)}"

COMPATIBLE_MACHINE:phycontrol-nova-imx8mp-1 = "phycontrol-nova-imx8mp-1"
