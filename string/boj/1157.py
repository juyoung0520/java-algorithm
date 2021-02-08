word = input().upper()
word_set = list(set(word))
word_count = []

for i in word_set:
    word_count.append(word.count(i))

if word_count.count(max(word_count)) >= 2:
    print('?')
else:
    print(word_set[word_count.index(max(word_count))])
