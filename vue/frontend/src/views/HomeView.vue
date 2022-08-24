<template>
  <div class="home">
    <Test/>
  </div>
</template>

<script>
// @ is an alias to /src
import Test from "@/components/basics/Test";

export default {
  name: 'HomeView',
  components: {
    Test
  }
}
</script>
