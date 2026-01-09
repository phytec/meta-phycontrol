meta-phyCONTROL
===============

This layer provides support for running PHYTEC's Yocto distribution "Ampliphy"
on phyCONTROL hardware.

Building the BSP
----------------

The BSP can be built using [kas](https://github.com/siemens/kas).

Create a new workspace directory, which will contain all sources and build
files:
```
mkdir phycontrol-workspace
cd phycontrol-workspace
```
Install kas in a virtual environment:
```
python3 -m venv env
source env/bin/activate
pip3 install kas
```
Clone the meta-phycontrol layer containing the kas manifest:
```
git clone https://github.com/phytec/meta-phycontrol
```
Use kas to checkout all required meta layers:
```
kas checkout meta-phycontrol/kas/ampliphy-vendor-rt-phycontrol-nova-imx8mp-1.yaml
```
Then build the BSP:
```
kas build meta-phycontrol/kas/ampliphy-vendor-rt-phycontrol-nova-imx8mp-1.yaml
```

> **Note**
>
> In case you don't have a [supported distribution](https://docs.yoctoproject.org/scarthgap/singleindex.html#supported-linux-distributions),
> use `kas-container` instead of running `kas` natively:
> ```
> KAS_CONTAINER_IMAGE_DISTRO=debian-bookworm kas-container build meta-phycontrol/kas/ampliphy-vendor-rt-phycontrol-nova-imx8mp-1.yaml
> ```

Reporting issues and contributing code
--------------------------------------

To report issues or contribute changes, please open
[issues](https://github.com/phytec/meta-phycontrol/issues) or
[pull requests](https://github.com/phytec/meta-phycontrol/pulls) at the GitHub
repository.

### Developing with KAS

By default `kas build` will discard any local changes. However, when developing,
it is useful to not overwrite these changes and just build the current state.
This can be done by skipping the checkout steps:
```
kas build --skip repos_checkout --skip finish_setup_repos meta-phycontrol/kas/ampliphy-vendor-phycontrol-nova-imx8mp-1.yaml
```

### Maintaining with KAS

Before releasing the KAS lock files must be updated:
```
kas lock --update meta-phycontrol/kas/ampliphy-vendor-rt-phycontrol-nova-imx8mp-1.yaml
kas lock --update meta-phycontrol/kas/ampliphy-vendor-rauc-rt-phycontrol-nova-imx8mp-1.yaml
```

Maintainer
----------

* Martin Schwan `m.schwan@phytec.de`
* Leonard Anderweit `l.anderweit@phytec.de`

License
-------

The metadata provided in this layer is licensed under MIT License. See the file
`LICENSE` for detailed information.
