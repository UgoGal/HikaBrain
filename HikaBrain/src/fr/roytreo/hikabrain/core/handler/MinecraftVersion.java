package fr.roytreo.hikabrain.core.handler;

import org.bukkit.Bukkit;

public enum MinecraftVersion {
	UNKNOWN(-1), 
	v1_7_R1(10701), 
	v1_7_R2(10702), 
	v1_7_R3(10703), 
	v1_7_R4(10704), 
	v1_8_R1(10801), 
	v1_8_R2(10802), 
	v1_8_R3(10803), 
	v1_8_R4(10804), 
	v1_9_R1(10901), 
	v1_9_R2(10902), 
	v1_10_R1(11001),
	v1_11_R1(11101),
	v1_12_R1(11201);

	private int version;

	private MinecraftVersion(int version) {
		this.version = version;
	}

	public int version() {
		return this.version;
	}

	public boolean olderThan(MinecraftVersion version) {
		return version() < version.version();
	}

	public boolean newerThan(MinecraftVersion version) {
		return version() >= version.version();
	}

	public boolean inRange(MinecraftVersion oldVersion, MinecraftVersion newVersion) {
		return (newerThan(oldVersion)) && (olderThan(newVersion));
	}
	
	public boolean inRange(MinecraftVersion... versions)
	{
		for (MinecraftVersion ver : versions)
			if (ver.version() == this.version())
				return true;
		return false;
	}

	public boolean matchesPackageName(String packageName) {
		return packageName.toLowerCase().contains(name().toLowerCase());
	}

	public static MinecraftVersion getVersion() {
		String name = Bukkit.getServer().getClass().getPackage().getName();
		String versionPackage = name.substring(name.lastIndexOf('.') + 1) + ".";
		for (MinecraftVersion version : values()) {
			if (version.matchesPackageName(versionPackage)) {
				return version;
			}
		}
		System.err.println("Failed to find version enum for '" + name + "'/'" + versionPackage + "'");
		return UNKNOWN;
	}
}
