<template>
  <div>
    <market-manager/>
    <inventory-manager/>
    <experience-manager/>
    <character-manager/>
    <monster-manager/>
  </div>
</template>

<script>

import MonsterManager from "@/components/basics/MonsterManager";
import CharacterManager from "@/components/basics/CharacterManager";
import MarketManager from "@/components/basics/MarketManager";
import InventoryManager from "@/components/basics/InventoryManager";
import ExperienceManager from "@/components/basics/ExperienceManager";

export default {
  name: "RpgGameView",
  components: {
    'monster-manager': MonsterManager,
    'character-manager': CharacterManager,
    'market-manager': MarketManager,
    'inventory-manager': InventoryManager,
    'experience-manager': ExperienceManager,
  },
}
</script>

<style scoped>

</style>