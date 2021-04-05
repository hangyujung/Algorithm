class Solution {
    public int solution(String skill, String[] skill_trees) {
        		int answer = 0;
		
		int index = 0;
		while(true) {
			String skill_tree = skill_trees[index];
			String skill_clone = new String(skill_tree);
			int size = skill_tree.length();
			for (int i =0; i < size; i++) {
				String oneSkill = String.valueOf(skill_clone.charAt(i));
				if (!skill.contains(oneSkill)) {
					skill_tree = skill_tree.replace(oneSkill, "");
				}
			}
			if (skill.indexOf(skill_tree) == 0) {
				answer++;
			}
			index++;
			if(index == skill_trees.length) break;
		}
	
		return answer;
    }
}
