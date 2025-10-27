FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = "\
    file://0001-arm-dts-freescale-Add-imx8mp-phycontrol-nova.patch \
"

COMPATIBLE_MACHINE:phycontrol-nova-imx8mp-1 = "phycontrol-nova-imx8mp-1"
