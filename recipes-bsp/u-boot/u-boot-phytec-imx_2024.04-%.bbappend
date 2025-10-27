FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append:phycontrol-nova-imx8mp-1 = " \
    file://0001-phycontrol-use-correct-fitimage-config.patch \
"

COMPATIBLE_MACHINE:phycontrol-nova-imx8mp-1 = "phycontrol-nova-imx8mp-1"
